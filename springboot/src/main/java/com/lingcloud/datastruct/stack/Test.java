package com.lingcloud.datastruct.stack;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {

        int[] arr = {9,4,12,5,8};
        sort(arr);
        System.out.println(Arrays.toString(arr));


        int[] arr2 = {8,3,2,1,7,4,6,5};
        sort2(arr2);
        System.out.println(Arrays.toString(arr2));

/*        final Stack<Integer> stack = new LineStack<>();


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
        }*/

    }

    public static void sort(int[] arr){
        if(arr != null && arr.length > 0){
            int tmp = 0;
            for(int i=0; i<arr.length-1; i++){
                for(int j=0; j<arr.length-1-i;j++){
                    if(arr[j] < arr[j+1]){
                        tmp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = tmp;
                    }
                }
            }
        }
    }

    public static void sort2(int[] arr){
        if(arr != null && arr.length > 0){
            int tmp = 0;
            for(int i=0; i<arr.length-1;i++){
                tmp = arr[i];
                int index = i;
                for(int j=i+1; j<arr.length;j++){
                    if(arr[j] < tmp){
                        tmp = arr[j];
                        index = j;
                    }
                }
                arr[index] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    //{18,6,12,8,4,9,22,78,3,100}
    public static void quickSort(int[] arr){
        if(arr != null && arr.length > 0){
            int index = 0;
            int left = arr[index];
            while(index < arr.length-1){


                left++;
            }
        }
    }

}
