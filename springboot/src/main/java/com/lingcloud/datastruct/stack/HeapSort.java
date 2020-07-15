package com.lingcloud.datastruct.stack;

import java.util.Arrays;

/**
 * @author wushiyuan
 * @version 1.0
 * @className HeapSort
 * @description
 * @date 2020-07-15 15:26
 **/
public class HeapSort implements IArraySort<Integer>{


    public static void main(String[] args) {

        Integer[] array = {4,1,15,17,3,9,28};

        HeapSort heapSort = new HeapSort();
        Integer[] result = heapSort.sort(array);

        System.out.println(Arrays.toString(result));

    }

    @Override
    public Integer[] sort(Integer[] sourceArray) {

        Integer[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr, len);

        for(int i = len - 1; i >0; i--){
            swap(arr, 0, i);
            len --;
            heapify(arr, 0, len);
        }

        return arr;
    }

    private void buildMaxHeap(Integer[] arr, int len) {

        for(int i=len/2; i >= 0; i--){
            heapify(arr, i ,len);
        }

    }

    private void heapify(Integer[] arr, int i, int len) {

        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;

        if(left < len && arr[left] > arr[largest]){
            largest = left;
        }

        if(right < len && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
            swap(arr, largest, i);
            heapify(arr, largest, len);
        }


    }

    private void swap(Integer[] arr, int largest, int i) {
        arr[largest] = arr[largest] ^ arr[i];
        arr[i] = arr[largest] ^ arr[i];
        arr[largest] = arr[largest] ^ arr[i];
    }

}
