package com.stream.array;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        String str ="racecar";

        String strReversed = new StringBuilder(str).reverse().toString();
        if(str.equals(strReversed)){
            System.out.println(str + " is palindrome");
        }else{
            System.out.println(str + "is not palindorme");
        }

        // Find  Longest Palindromic Substring

    }
}
