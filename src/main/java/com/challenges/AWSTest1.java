package com.challenges;

import java.util.*;

public class AWSTest1 {
    public static void main(String[] args) {

        List<String> boxList = Arrays.asList( new String[]{"ykc 82 01", "eo first qpx", "09z cat hamster", "06f 12 25 6", "az0 first qpx", "236 cat dog rabbit snake"} );

        List<String> result = new ArrayList<>();
        List<String> newArray = new ArrayList<>();

        //i need to have my old value as an auxiliary to manipulate if after
        List<List<String>> oldValue = new ArrayList<>();

        for (String stringBox : boxList) {
            int indexOf = stringBox.indexOf(" "); //indexof each string with space

            String firstSubst = stringBox.substring(indexOf); //set a new string from my subs with indexof
            String secondSubst = stringBox.substring(indexOf + 1 ); //same

            boolean isDigit = true;

            for (char c : secondSubst.toCharArray()) {
                if (!Character.isDigit(c) && c != ' ')
                    isDigit = false;
            }

            if (isDigit) {
                newArray.add(stringBox);
            } else {
                List<String> list = new ArrayList<>();
                list.add(firstSubst);
                list.add(secondSubst);
                secondSubst.replaceAll(" ", "-");
                list.add(stringBox);
                oldValue.add(list);
            }
        }

        Collections.sort(oldValue, ((a, b) -> (!a.get(1).equals(b.get(1)) ? a.get(1).compareTo(b.get(1)) : a.get(0).compareTo(b.get(0)))));

        Collections.sort(oldValue, (o1, o2) -> 0 );

        for (List<String> list : oldValue)
            result.add(list.get(2));

        result.addAll(newArray);
        System.out.println(result);
    }

}
