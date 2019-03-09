package com.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {

        //int[] states = new int[]{1, 0, 0, 0, 0, 1, 0, 0};
        //int days = 1;

        int[] states = new int[]{1,1,1,0,1,1,1,1};
        int days = 2;

        int len = states.length;
        int[] newCells = new int[states.length];
        for (int k = 0; k < days; k++) {
            for (int i = 0; i < states.length; i++) {
                int cell = states[i];
                int nextCell;
                int prevCell;
                int activenumber;
                if (i == 0) {
                    // edge cases
                    nextCell = states[1];
                    prevCell = 0;
                } else if (i == states.length - 1) {
                    // edge case
                    prevCell = states[states.length - 2];
                    nextCell = 0;
                } else {
                    nextCell = states[i + 1];
                    prevCell = states[i - 1];
                }
                if (nextCell == prevCell) {
                    // set it to inactive
                    activenumber = 0;
                } else {
                    //set it to active
                    activenumber = 1;
                }
                newCells[i] = activenumber;
            }
            for (int i = 0; i < 8; i++) {
                states[i] = newCells[i];
            }
        }

        List<Integer> list = Arrays.stream(newCells).boxed().collect(Collectors.toList());

        System.out.println(list);

    }
}
