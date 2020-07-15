package com.lingcloud.mt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author wushiyuan
 * @version 1.0
 * @className TitleMapping
 * @description
 * @date 2019-06-25 18:58
 **/
public class RightNameMap {

    protected static Logger logger = LoggerFactory.getLogger(RightNameMap.class);
    private static BufferedReader br;
    private static BufferedWriter bw;
    private final static String regx = "[a-zA-Z\\s]+";


    public static Map<String,Map<String,Integer>> doRightMap(String path) throws IOException {
        long start = System.currentTimeMillis();
        Assert.notNull(path,"文件路径不能为空！");
        File file = new File(path);
        if(file.exists() == false){
            logger.error("文件不存在！");
            return null;
        }
        br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        Stream<String> lines = br.lines();
        int length = line.length();
        System.out.println("长度为："+length);
        Map<String,Map<String,Integer>> map = new HashMap<>(256);
        while(line != null){
            Pattern pattern = Pattern.compile(regx);
            Matcher matcher = pattern.matcher(line);
            List<String> data = new ArrayList<>();
            while(matcher.find()){
                String group = matcher.group();
                group = group.trim();
                if(group.contains(" ")){
                    data.add(group);
                }

            }
            if(data.size()>0){
                String[] result = new String[data.size()];
                data.toArray(result);
                for(int i=0;i<result.length;i++){
                    String words = result[i];
                    //System.out.println("words:"+words);
                    String[] split = words.split("\\s+");
                    if(split.length > 1){
                        for(int x=0;x<split.length;x++){
                            String s = split[x];
                            String b = null;
                            for(int y=x+1;y<split.length;y++){
                                Map<String,Integer> sonMap = new HashMap<>();
                                if(b!=null){
                                    b= b+split[y]+"#";
                                }else{
                                    b = split[y]+"#";
                                }
                                //b = b.substring(0,b.length()-1);
                                String sonKey = s + "#" + b;
                                String key = (s+b).toLowerCase();
                                sonMap.put(sonKey.replaceAll("#"," ").toLowerCase(),1);
                                if(map.containsKey(key.replaceAll("#","").toLowerCase())){
                                    Map<String, Integer> integerMap = map.get(key.replaceAll("#", ""));
                                    if(integerMap.containsKey(sonKey.replaceAll("#"," ").toLowerCase())){
                                        Integer value = integerMap.get(sonKey.replaceAll("#", " ").toLowerCase());
                                        value = value + 1;
                                        integerMap.put(sonKey.replaceAll("#", " ").toLowerCase(),value);
                                    }else{
                                        integerMap.put(sonKey.replaceAll("#"," ").toLowerCase(),1);
                                    }
                                }else{
                                    map.put(key.replaceAll("#","").toLowerCase(),sonMap);
                                }

                                //System.out.println(map);
                                //list.add(s+"#"+b);
                            }
                            s = null;
                        }
                    }
                }
            }
            //System.out.println("最终的结果："+map);
            line = br.readLine();
        }
        long end = System.currentTimeMillis();
        System.out.println("总共耗时："+(end-start)/1000);
        return map;
    }

    /**
     * 取每个map里面值最大的
     * @param oldMap
     * @return
     */
    public static Map<String,String> obtainMaxValue(Map<String,Map<String,Integer>> oldMap){

        Map<String,String> newMap =  new HashMap<>();
        Set<Map.Entry<String, Map<String, Integer>>> entries = oldMap.entrySet();
        /*for(Map.Entry<String, Map<String, Integer>> entry : entries){
            Map<String,Integer> sonMap = new HashMap<>();
            String key = entry.getKey();
            Map<String,Integer> value = entry.getValue();
            List<Map.Entry<String,Integer>> list = new ArrayList<>(value.entrySet());
            Collections.sort(list,(o1,o2)->o2.getValue().intValue() - o1.getValue().intValue());
            String sonKey = list.get(0).getKey();
            Integer sonValue = list.get(0).getValue();
            sonMap.put(sonKey,sonValue);
            newMap.put(key,sonKey);

        }*/
        return newMap;
    }

    /**
     * 将map写到文件中
     * @param map
     */
    public static void writeFile(Map<String, String> map,String path) throws IOException {
        Assert.notNull(path,"文件路径不能为空！");
        File file = new File(path);
        boolean flag = false;
        if(file.exists() == false){
            flag = file.createNewFile();
        }
        if(flag){
            bw = new BufferedWriter(new FileWriter(file));
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for(Map.Entry<String, String> entry : entries){
                String key = entry.getKey();
                String value = entry.getValue();
                if(key.length()>3 && value !=null && !value.equals("")){
                    String keyValue = key + "，" + value;
                    bw.write(keyValue,0,keyValue.length()-1);
                    bw.newLine();
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        String path = "conf/goods_name.txt";
        String writePath = "conf/goods_name_new.txt";
        Map<String, Map<String, Integer>> map = doRightMap(path);
        Map<String, String> stringMap = obtainMaxValue(map);
        writeFile(stringMap,writePath);
        System.out.println(stringMap.size());
        System.out.println(stringMap);

    }

}
