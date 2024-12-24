package com.stream.string;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseWordInString {

    public static void main(String[] args) {
        // Input string
        String input = "Hello World from Java";
        //System.out.println("Original String: " + input);

        // Call the method to reverse words
        String reversed = reverseWords(input);
        System.out.println("Reversed Words: " + reversed);
    }

    private static String reverseWords(String input) {

        String[] str = input.split(" ");


        //Arrays.stream(str).forEach(System.out::println);
        StringBuilder builder = new StringBuilder();
        for(int i = str.length - 1; i >=0; i--){
            builder.append(str[i]).append(" ");
        }
        //System.out.println(builder.toString());


        return builder.toString();
    }
}
