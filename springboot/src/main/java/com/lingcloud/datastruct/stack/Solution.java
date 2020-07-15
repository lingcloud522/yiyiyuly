package com.lingcloud.datastruct.stack;

/**
 * @author wushiyuan
 * @version 1.0
 * @className Solution
 * @description
 * @date 2020-06-17 10:49
 **/
public class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n){

        int p = m + n - 1;

        m = m - 1;
        n = n - 1;

        while(m >= 0 && n >= 0){
            nums1[p] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            p--;
        }

        while (n >= 0) {
            nums1[p] = nums2[n--];
            p--;
        }

        System.out.println(nums1);
    }

/**
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

             

    示例：
1
 -4 -1 1 2

    输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
             

    提示：

            3 <= nums.length <= 10^3
            -10^3 <= nums[i] <= 10^3
            -10^4 <= target <= 10^4





 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，
 其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。


**/


    public static void main(String[] args) {

        int[] nums = {4,1,9,12,7,19,9,20,48};

        int pivot = nums.length / 2;

        for(int i = pivot; i > 0; i = pivot / 2){



        }

    }


}
