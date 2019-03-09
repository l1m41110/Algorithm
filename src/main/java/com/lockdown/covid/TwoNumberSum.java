package com.lockdown.covid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
    If any two numbers in the input array sum up to the target sum, the function should return them in an array.
    If no two numbers sum up to the target sum, the function should return an empty array.
    Assume that there will be at most one pair of numbers summing up to the target sum.

    *three number sum, four --> not covered

    1: two loops
    - you have to traverse the array twice (2 loops) and find the sum
    - traverse once go through each number individually
    - at each number traverse the rest the array and try to find the sum
    - not optimal - N square time

    2: hash table (it will extra space but it will make the code faster)
    - traverse array
    - store every number in a hashtable (constant time) O(1)
    - traverse array
    - each number check if the number needed to sum up to target it is stored
    - x + y = 10
    - y = 10 - x to find y (constant time accessing y in the hash table)

    input: [3,5,-4,8,11,1,-1,6],10
    output: [11, -1]

    eg:
    y10-3=7 (not in the hashtable) -> add 3: true in the hashtable
    y=10-5=5 (not in the hashtable) -> add 5: true
    y=10-(-4)=14 (not in the hashtable) -> add -4: true
    y=10-8=2 (not in the hashtable) -> add 8: true
    y=10-11=-1 (not in the hashtable YET) -> add 11: true
    y=10-1=9 (not in the hashtable YET) -> add 1: true
    y=10-(-1)=11 (YES, it is in the hashtable) -> return 11 and -1
    O(N) Time complexity: traverse array only once and each number calculating y, sum, and accessing hashtable constant
    O(N) Space complexity: adding values to hashtable only

    3: sorting the array without hashtable more optimal with double loops: quicksort, mergesort, heapsort O(Nlog(N)) T
    sorted: [-4,-1,1,3,5,6,8,11],10
    find O(N) T dont use any additional space
    once we sort the array
    add left pointer and right pointer. sum these pointers
    sum and compare to the target
    eg:
    -4+11=7-not
    if 7 less than 10 and i have sorted array.
    8 is less then 11, new sum will be smaller
    then move the left pointer to the right
    -1+11=10(ANSWER)
*/
public class TwoNumberSum {

    //O(n^2) T, O(1) S
    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            int firstNum = array[i];

            for (int j = i + 1; j < array.length; j++) {
                int secondNum = array[j];

                if (firstNum + secondNum == targetSum)
                    return new int[]{firstNum, secondNum};
            }
        }

        return new int[0];
    }

    //O(n) TS
    public static int[] twoNumberSum2(int[] array, int targetSum) {
        Map<Integer, Boolean> numbers = new HashMap<>();

        for (int num : array) {
            int numberMatch = targetSum - num;

            if (numbers.containsKey(numberMatch))
                return new int[]{numberMatch, num};

            numbers.put(num, true);
        }

        return new int[0];
    }

    //O(nLog(n)) T, O(n) S
    public static int[] twoNumberSum3(int[] array, int targetSum) {
        Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int current = array[left] + array[right];

            if (current == targetSum) {
                return new int[]{array[right], array[left]};

            } else if (current < targetSum) {
                left++;

            } else {
                right--;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] result = twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(result));

        int[] result2 = twoNumberSum2(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(result2));

        int[] result3 = twoNumberSum3(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(result3));
    }

}
