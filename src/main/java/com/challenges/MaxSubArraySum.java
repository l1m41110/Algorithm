package com.challenges;

public class MaxSubArraySum {
    public static void main(String[] args) {

        int[] first = {1, -3, 2, 1, -1};

        int[] second = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(MaxSumKadane(first));
        System.out.println(MaxSumKadane(second));
    }

    /*Brute force solution: checking all the subarrays: Not a good time optimal solution: O(n^2)*/


    //The optimal solution is Kadane's Algorithm
    //look at each index and ask what is the max subarray under this index. we can run it at linear time O(n)
    public static int MaxSumKadane(int[] array) {

        int maxCurrent = 0;
        int maxGlobal = 0;
        maxCurrent = maxGlobal = array[0];

        for (int i = 1; i < array.length - 1; i++) {
            maxCurrent = Math.max(array[i], maxCurrent + array[i]);

            if (maxCurrent > maxGlobal)
                maxGlobal = maxCurrent;
        }

        return maxGlobal;
    }

}
