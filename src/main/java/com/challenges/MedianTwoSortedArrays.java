package com.challenges;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MedianTwoSortedArrays {

    public static void main(String[] args) {

        int[] num1 = {1, 3};
        int[] num2 = {2};

        double result = findMedianSortedArrays(num1,num2);

        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1, nums2);
        int medianIndex = (int)Math.ceil((nums1.length+nums2.length)/2.0)-1;
        int needAverage = (nums1.length+nums2.length)%2;
        if (needAverage == 0) {
            return (arr[medianIndex]+arr[medianIndex+1])/2.0;
        }
        return arr[medianIndex];
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int[] arr = new int[arr1.length+arr2.length];
        while (i + j < arr.length) {
            if (i == arr1.length) {
                arr[i+j] = arr2[j++];
            }
            else if (j == arr2.length) {
                arr[i+j] = arr1[i++];
            }
            else if (arr1[i] < arr2[j]) {
                arr[i+j] = arr1[i++];
            }
            else {
                arr[i+j] = arr2[j++];
            }
        }
        return arr;
    }
}
