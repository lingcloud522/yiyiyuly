package com.lingcloud.fptree;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.*;

/**
 * @author wushiyuan
 * @version 1.0
 * @className FPTree
 * @description
 * @date 2019-08-06 17:15
 **/
public class FPTree {

    private static Map<String,Integer> mQueryToNumber = new HashMap<>();
    private static BufferedReader br;
    private static BufferedWriter bw;
    //头指针表
    HeadTable mHeadTable = null;
    Tree mTree = null;

    /**
     * 最小支持度
     */
    private static int minSupport= 3;

    /**
     * 将文件query存入到mQueryToNumber
     */
    private static void statisticsQueryNum() throws IOException {
        File file = new File("./data/query.txt");
        br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while (line!=null){
            String[] terms = line.split(" ");
            for(String term : terms){
                if(mQueryToNumber.containsKey(term)){
                   Integer count = mQueryToNumber.get(term);
                   count += 1;
                   mQueryToNumber.put(term,count);
                }else{
                    mQueryToNumber.put(term,1);
                }
            }
            line = br.readLine();
        }

    }
    /**
     * 移除不满足最小支持度的项
     * 如果一个项都不满足最小支持度，那么它的超集必定不满足
     * A={牛奶，面包}，B={牛奶}  A是超集 B是子集
     */
    private static void filterQuery() throws IOException {
        File file = new File("./data/query.txt");
        br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        List<String> terms = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(line != null){
            String[] words = line.split(" ");
            for(String word : words){
                Integer count = mQueryToNumber.get(word);
                if(count>=minSupport){
                    sb.append(word + " ");
                }
            }
            String term = sb.toString().trim();
            if(!StringUtils.isEmpty(term)){
                terms.add(sb.toString().trim());
            }
            sb.delete(0,sb.length());
            line = br.readLine();
        }
        bw = new BufferedWriter(new FileWriter(new File("./data/newQuery.txt")));
        for(String term : terms){
            bw.write(term);
            bw.write("\n");
        }
        bw.flush();
    }

    /**
     * 构建头指针表
     */
    private void constructHeadtable(){
        //query数量
        int queryNum = mQueryToNumber.size();
        //初始化头指针表
        mHeadTable = new HeadTable(queryNum);
        List<Term> queryList = new ArrayList<>();
        Set<String> keys = mQueryToNumber.keySet();
        for(String key : keys){
            Integer value = mQueryToNumber.get(key);
            Term term = new Term(key,value);
            queryList.add(term);
        }
        //按照query数目排序
        queryList.sort(Comparator.comparing(Term::getmNum).reversed().thenComparing(Term::getmQuery));

        //填充头指针表
        int len = queryList.size();
        mHeadTable.mLen = len;
        for(int i=0;i<len;i++){
            Term term = queryList.get(i);
            mHeadTable.mQuery[i] = term.mQuery;
            mHeadTable.mCount[i] = term.mNum;
            mHeadTable.mQueryToIndex.put(term.mQuery,i);
        }


    }

    /**
     * 创建fptree
     */
    private void createTree() throws IOException {

        File file = new File("./data/newQuery.txt");
        br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while (line!=null){
            List<Term> terms = new ArrayList<>();
            String[] words = line.split(" ");
            for(String word : words){
                Integer index = mHeadTable.mQueryToIndex.get(word);
                terms.add(new Term(word,index));
            }
            terms.sort(Comparator.comparing(Term::getmNum).reversed());
            Term[] termArr = terms.toArray(new Term[terms.size()]);
            insertOneQueryArrayToFPTree(termArr,new Tree(),3);
        }
    }

    private void insertOneQueryArrayToFPTree(Term[] tmA, Tree t, int supp) {
        Node node, cNode;
        String name;

        node = t.root;//把根节点赋值给node
        for (int i = 0; i < tmA.length; i++) {
            name = tmA[i].mQuery;
            //根据name找根节点的孩子节点
            cNode = node.findChild(node, name);

            if (cNode != null) {
                cNode.incCount(supp);
                node = cNode;
            } else {
                node = node.insertNode(name, supp);
            }
        }
    }

    class Tree {
        Node root;

        Tree() {
            root = new Node();
        }
    }

    public static void main(String[] args) throws IOException {
        /*statisticsQueryNum();
        filterQuery();
        FPTree fpTree = new FPTree();
        fpTree.createTree();
        fpTree.constructHeadtable();*/
        System.out.println((Math.pow(2,30) > 1000000000.0));
    }


    /**
     * 头指针表
     */
    class HeadTable{
        //访问数目
        public int[] mCount;
        //用户query
        public String[] mQuery;
        //头指针
        public Node[] mLink;
        //query对应的下标
        public Map<String,Integer> mQueryToIndex = new HashMap<>();
        //头指针的个数
        int mLen;
        public HeadTable(int num) {
            mCount = new int[num];
            mQuery = new String[num];
            mLink = new Node[num];
            mLen = num;
        }
    }
    class Node {
        String mQuery;//项目名称
        int mCount;//支持度计数
        Node mRight;//兄弟节点
        Node mParent;//父节点
        Cnode mChild;//孩子节点

        Node() {
            mCount = 0;
            mQuery = "root";
            mRight = null;
            mParent = null;
            mChild = null;//new Cnode();
        }

        Node(String name) {
            mCount = 0;
            mQuery = name;
            mRight = null;
            mParent = null;
            mChild = null;//new Cnode();
        }

        public Node findChild(Node d, String item) {
            String it;
            Cnode c;
            Node t;
            //把d的孩子节点赋值给c
            c = d.mChild;
            while (c != null) {
                t = c.mLink;
                it = c.mLink.mQuery;
                if (it.equals(item))
                    return c.mLink;

                c = c.mNext;
            }
            return null;
        }

        void incCount(int num) {
            mCount += num;
        }

        //在当前节点下插入孩子节点,返回新节点
        Node insertNode(String item, int count) {
            Cnode c;
            Cnode temp = new Cnode();
            Node d = new Node(item);
            d.incCount(count);
            temp.mLink = d;
            d.mParent = this;
            c = this.mChild;

            if (c == null) {
                this.mChild = temp;
                int index = mHeadTable.mQueryToIndex.get(item);
                Node tmpNode = mHeadTable.mLink[index];
                if (tmpNode == null) {
                    mHeadTable.mLink[index] = d;
                } else {
                    d.mRight = tmpNode;
                    mHeadTable.mLink[index] = d;
                }

                return d;
            }

            while (c.mNext != null) {
                c = c.mNext;
            }
            c.mNext = temp;

            //插入到头指针表
            int index = mHeadTable.mQueryToIndex.get(item);
            Node tmpNode = mHeadTable.mLink[index];
            if (tmpNode == null) {
                mHeadTable.mLink[index] = d;
            } else {
                d.mRight = tmpNode;
                mHeadTable.mLink[index] = d;
            }
            return d;
        }
    }
    //孩子节点
    class Cnode {
        Cnode mNext;//下一个孩子节点
        Node mLink;//孩子节点信息

        Cnode() {
            mNext = null;
            mLink = null;
        }
    }

    public static class Term {
        Term(String query, int count) {
            mQuery = query;
            mNum = count;
        }

        public String mQuery = "";
        public int mNum = 0;//排序依据  词的index位置

        public String getmQuery() {
            return mQuery;
        }

        public void setmQuery(String mQuery) {
            this.mQuery = mQuery;
        }

        public int getmNum() {
            return mNum;
        }

        public void setmNum(int mNum) {
            this.mNum = mNum;
        }
    }

}
