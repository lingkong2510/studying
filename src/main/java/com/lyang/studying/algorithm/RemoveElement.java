package com.lyang.studying.algorithm;

import java.util.Arrays;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/1/5 10:39 上午
 * @desc 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    public static int removeElementFunc(int[] nums, int val) {
        int left = 0;
        for (int right = 0;right < nums.length; right++){
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return left;
    }

    public static void main(String[] args) {
//        int[] arr = {3,1,1,3};
        int[] arr = {1,2,4,5,1,3,4,7,1,9};
//        int[] arr = {1};
        int length = removeElementFunc3(arr, 1);
        System.out.println(length);
    }

    public static int removeElementFunc2(int[] nums, int val){
        int left = 0;
        for (int right = 0;right < nums.length; right++){
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }

        }
        System.out.println(Arrays.toString(nums));
        return left;
    }

    public static int removeElementFunc3(int[] nums ,int val){
        int left = 0;
        for (int right = 0; right < nums.length;right++) {
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return left;
    }

}
