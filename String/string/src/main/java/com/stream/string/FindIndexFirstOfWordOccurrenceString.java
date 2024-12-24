package com.stream.string;

import java.util.Arrays;

public class FindIndexFirstOfWordOccurrenceString {

    public static void main(String[] args) {
        String input = "as a career path java programming language should be selected by fresher. insteadof java a fresher should choose c c++ javascript python as a programming language";


        // Split by whitespace and '.'
        String[] result = input.split("\\s+|\\.");
        Arrays.stream(result).filter(f->!f.isEmpty()).forEach(System.out::println);// No whitespace in output

        String toFindIndexOf = "programming";

        int index = findIndexOfWordInString(result, toFindIndexOf);
        if(index >=0){
            System.out.println(toFindIndexOf+" firstly found at position " +  index);
        }else{
            System.out.println("Not found");
        }
    }

    private static int findIndexOfWordInString(String[] input, String toFindIndexOf) {

        for(int i = 0; i < input.length; i++){

            if(toFindIndexOf.equals(input[i]))
                return i;

        }
        return -1;// Not found in Array
    }

}
