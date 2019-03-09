package com.challenges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {

        int num[] = {2, 7, 11, 15};

        int[] result = calculate( num,9);

        for(int r: result){
            System.out.println(r);
        }

    }


    //Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1)O(1) time.
    //Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
    public static int[] calculate(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);

        }
        throw new IllegalArgumentException("No two sum solution");

    }
}
