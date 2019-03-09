package com.challenges;

import java.util.*;

public class AWSTest2 {
    public static void main(String[] args) {

        List<List<Integer>> foregroundAppList = new ArrayList<>();
        List<List<Integer>> backgroundAppList = new ArrayList<>();

        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(8);
        foregroundAppList.add(li);
        li = new ArrayList<>();
        li.add(2);
        li.add(7);
        foregroundAppList.add(li);
        li = new ArrayList<>();
        li.add(3);
        li.add(14);
        foregroundAppList.add(li);

        li = new ArrayList<>();
        li.add(1);
        li.add(5);
        backgroundAppList.add(li);
        li = new ArrayList<>();
        li.add(2);
        li.add(10);
        backgroundAppList.add(li);
        li = new ArrayList<>();
        li.add(3);
        li.add(14);
        backgroundAppList.add(li);

        List<List<Integer>> lists = optimalUtilization(20, foregroundAppList, backgroundAppList);
        System.out.println(lists.get(0));
    }

    public static List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foregroundAppList,
                                           List<List<Integer>> backgroundAppList) {

        foregroundAppList.sort((Comparator.comparingInt( a -> a.get( 1 ))));
        backgroundAppList.sort((Comparator.comparingInt( a -> a.get( 1 ))));

        Map<Integer, List<List<Integer>>> myHashMap = new HashMap<>();

        for (int i = 0; i < foregroundAppList.size(); i++) {
            int aux = 0;
            int fAppList = foregroundAppList.get(i).get(1);

            while (aux < backgroundAppList.size() && fAppList + backgroundAppList.get(aux).get(1) <= deviceCapacity) {
                aux++;
            }

            aux--;
            if (aux < 0)
                continue;

            int diff = deviceCapacity - fAppList - backgroundAppList.get(aux).get(1);

            if (!myHashMap.containsKey(diff))
                myHashMap.put(diff, new ArrayList<>());

            List<Integer> itemToDiff = new ArrayList<>();
            itemToDiff.add(foregroundAppList.get(i).get(0));
            itemToDiff.add(backgroundAppList.get(aux).get(0));
            myHashMap.get(diff).add(itemToDiff);

            while (aux > 0 && backgroundAppList.get(aux).get(1).intValue() == backgroundAppList.get(aux - 1).get(1).intValue()) {
                List<Integer> newArr = new ArrayList<>();
                newArr.add(foregroundAppList.get(i).get(0));
                newArr.add(backgroundAppList.get(aux - 1).get(0));
                aux--;
                myHashMap.get(diff).add(newArr);
            }

        }

        if (myHashMap.isEmpty())
            return new ArrayList<>();

        int minValue = Integer.MAX_VALUE;

        for (int key : myHashMap.keySet()) {
            if (key < minValue)
                minValue = key;
        }

        return myHashMap.get(minValue);
    }
}
