package com.challenges

import spock.lang.Specification

/*
For strings s and t, we say t divides s
if and only s = t + ... + t (t concatenated with itself 1 or more times
return the largest string x such that x divides str1 and x divides str2
 */
class GreatestCommonDivisorOfStringTest extends Specification {

    def "Should return ABC"() {

        given: "2 strings"

        String str1 = "ABCABC"
        String str2 = "ABC"

        when: "Call Service"

        def result = GCDOfStringService.calculate(str1, str2)

        then: "return ABC"

        "ABC" == result
    }

    def "Should return AB"() {

        given: "2 strings"

        String str1 = "ABABAB"
        String str2 = "ABAB"

        when: "Call Service"

        def result = GCDOfStringService.calculate(str1, str2)

        then: "return AB"

        "AB" == result
    }

    def "Should return string empty"() {

        given: "2 strings"

        String str1 = "LEET"
        String str2 = "CODE"

        when: "Call Service"

        def result = GCDOfStringService.calculate(str1, str2)

        then: "return string empty"

        "" == result
    }
}

class GCDOfStringService {

    static calculate(String str1, String str2){

        if(str1.isEmpty())
            return str2

        else if(str2.isEmpty())
            return str1

        else if(str1.length() >= str2.length()){
            if(!str1.startsWith(str2))
                return ""

            return calculate(str1.substring(str2.length()), str2)

        }else{
            return calculate(str2, str1)
        }

    }

    /*
    static calculate(String str1, String str2) {
        while(true){
            if(str1 + str2 != str2 + str1)
                return ""

            if(str1 == str2)
                return str1

            if(str1.length() > str2.length())
               return str1.substring(str2.length())

            if(str2.length() > str1.length())
                return str2.substring(str1.length())

            return ""
        }
    }
    */
}