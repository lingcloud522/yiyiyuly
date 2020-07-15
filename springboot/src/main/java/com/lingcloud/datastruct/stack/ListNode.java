package com.lingcloud.datastruct.stack;

import java.util.List;

/**
 * @author wushiyuan
 * @version 1.0
 * @className ListNode
 * @description
 * @date 2019-08-02 14:10
 **/
public class ListNode {

    ListNode next;
    int value;

    public ListNode(){}

    public ListNode(ListNode next,int value){
        this.next = next;
        this.value = value;
    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }

    public static void main(String[] args){
        ListNode listNode = new ListNode(new ListNode(new ListNode(new ListNode(),3),2),1);
        LineStack<ListNode> stack = new LineStack<>();
        while(listNode!=null){
            ListNode curr = new ListNode();
            curr.value = listNode.value;
            stack.push(curr);
            listNode = listNode.next;
        }
        ListNode prev = null;
        while(!stack.isEmpty()){
            ListNode curr = stack.pop();
            curr.next = prev;
            prev = curr;
        }
        System.out.println(prev);
    }

}
