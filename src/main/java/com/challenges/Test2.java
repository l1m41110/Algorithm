package com.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {

        int[] arr = new int[]{2,3,4,5,6};
        int num = 5;


        int result = arr[0];

        for(int i=1; i<num; i++){
            result = helper(arr[i], result);
        }

        System.out.println(result);
    }

    public static int helper(int a, int b){
        if(a == 0)
            return b;
        return helper(b%a, a);
    }
}
