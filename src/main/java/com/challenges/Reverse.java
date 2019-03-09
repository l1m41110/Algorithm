package com.challenges;

import java.util.Arrays;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse("ab"));

        System.out.println(new StringBuilder("abcd").reverse().toString());

        int[] first = {1, -3, 2, 1, -1};

        int[] reverseArray = reverseArray(first);

        System.out.println(Arrays.toString(reverseArray));
    }

    String reverse(String input) {
        if (input.length() < 2) {
            return input;
        }
        return reverse(input.substring(1)) + input.charAt(0);
    }

    //O(n)
    static int[] reverseArray(int[] array){
        for(int i=0; i< array.length/2; i++){
            int other = array.length - i - 1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
        return array;
    }

}
