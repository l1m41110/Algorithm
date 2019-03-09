package com.challenges

import spock.lang.Specification

/*
Input : malayalam
Output : Yes
Reverse of malayalam is also
malayalam.

Input : max
Output : No
Reverse of max is not max.
 */

class PalindromeTest extends Specification{

    def "Should return true"(){

        given: "malayalam"

            String word = "malayalam"

        when: "Call Service"

            def isPalindrome = PalindromeService.isPalindrome(word)

        then: "return true"

            isPalindrome
    }

    def "Should return true 1"(){

        given: "ABBA"

            String word = "ABBA"

        when: "Call Service"

            def isPalindrome = PalindromeService.isPalindrome(word)

        then: "return true"

            isPalindrome
    }

    def "Should return false"(){

        given: "max"

            String word = "max"

        when: "Call Service"

            def isPalindrome = PalindromeService.isPalindrome(word)

        then: "return false"

            !isPalindrome
    }

}

class PalindromeService{

    static boolean isPalindrome(String s) {
//        int n = s.length()
//        for (int i = 0; i < (n/2); ++i) {
//            if (s.charAt(i) != s.charAt(n - i - 1)) {
//                return false
//            }
//        }
//
//        return true

        if(s == new StringBuilder(s).reverse().toString())
            return true
        return false
    }

}