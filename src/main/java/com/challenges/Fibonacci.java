package com.challenges;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(FibRecursiveApproach(6));

        System.out.println(FibDynamicApproach(6));

        System.out.println(FibRecursiveApproach(7));

        System.out.println(FibDynamicApproach(7));
    }


    //time consuming not good: to find n-th number is O(2^n)
    public static int FibRecursiveApproach(int n) {
        if (n == 1 || n == 2)
            return 1;

        return FibRecursiveApproach(n - 1) + FibRecursiveApproach(n - 2);
    }


    //better solution because is linear time: O(n)
    public static int FibDynamicApproach(int n) {
        int[] seq = new int[n];
        seq[0] = seq[1] = 1;

        for(int i = 2; i <= (n -1); i++){
            seq[i] = seq[i -1] + seq[i -2];
        }

        return seq[n - 1];
    }
}
