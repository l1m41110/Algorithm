package com.challenges

import spock.lang.Specification

class CapitalizeStringTest extends Specification{

    def "Should apply upper case to first word in a string"(){

        given: "My phrase"

            String phrase = "i love solving problems and it is fun"

        when: "Call CaptilizeString()"

            String phraseReturned = Service.capitalizeString(phrase)

        then: "Receive string: I Love Solving Problems and It Is Fun"

            String correctFormat = "I Love Solving Problems and It Is Fun"

            correctFormat.contentEquals(phraseReturned)
    }

    def "Should apply upper case to first word in a unorder string"(){

        given: "My phrase"

            String phrase = "wHY DoES A bIRD FlY?"

        when: "Call CaptilizeString()"

            String phraseReturned = Service.capitalizeString(phrase)

        then: "Receive string: Why Does A Bird Fly?"

            String correctFormat = "Why Does a Bird Fly?"

            correctFormat.contentEquals(phraseReturned)
    }

    def "Should not receive error if string is empty"(){

        given: "Empty string"

            String phrase = ""

        when: "Call CaptilizeString()"

            String phraseReturned = Service.capitalizeString(phrase)

        then: "Receive string: empty"

            String correctFormat = ""

            correctFormat.contentEquals(phraseReturned)
    }
}

 class Service {
    static String capitalizeString(phrase){
        if(phrase.isEmpty())
            return "";

        phrase = phrase.toLowerCase()

        List<String> listExceptions = Arrays.asList("a", "the", "to", "at", "in", "with", "and", "but", "or");

        String[] word = phrase.split(" ")

        for(Integer i = 0; i < word.length; i++){
            if(i == 0 || i == word.length -1 || !listExceptions.contains(word[i]))
                word[i] = toUpperCase(word[i]);
        }

        return String.join(" ", word);
    }

   static String toUpperCase(word){
        String first = word.charAt(0).toUpperCase();
        String last = word.substring(1);
        return first + last;
    }
}

