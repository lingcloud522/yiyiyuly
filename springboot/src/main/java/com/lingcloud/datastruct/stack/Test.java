package com.lingcloud.datastruct.stack;

public class Test {


    public static void main(String[] args) {
        final Stack<Integer> stack = new LineStack<>();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stack.push(1);
                stack.push(2);
                stack.push(3);
                stack.push(4);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                stack.push(5);
                stack.push(6);
                stack.push(7);
                stack.push(8);
            }
        });

        t1.start();
        t2.start();
        while(stack.length()>0){
            System.out.print(stack.pop());
        }

    }
}
