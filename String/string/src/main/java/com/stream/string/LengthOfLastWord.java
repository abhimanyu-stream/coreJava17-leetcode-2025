package com.stream.string;

public class LengthOfLastWord {
    public static void main(String[] args) {

        String input = "as a career path java programming language should be selected by fresher";

        String[] str = input.split(" ");


       int length = findLengthOfLastWordInString(str);
        System.out.println(length);

    }

    private static int findLengthOfLastWordInString(String[] str) {
        int length = 0;
        for(int i = str.length - 1; i >=0;i--){
            length = str[i].length();
            break;
        }
        return length;
    }

}
