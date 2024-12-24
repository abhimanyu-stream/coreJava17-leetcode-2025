package com.stream.string;

public class WordSearch {

    public static void main(String[] args) {

        //String[] str = new String[]{"as a career path java programming langugae should be selected by fresher"};
        String input = "as a career path java programming language should be selected by fresher";

        String[] str = input.split(" ");
        String toSearch = "java";
        String result = searchWordInStr(str, toSearch);
        System.out.println(result);
    }

    private static String searchWordInStr(String[] str, String toSearch) {
        String foundMessage = null;
        for(int i = 0; i < str.length; i++){
            if(toSearch.equals(str[i])) {
              return  foundMessage = "at position " + i + " word " + toSearch + " is found";
            }

        }
        return "Not found"; // Return this only if the word is not found


    }
}


/**
 *  for(int i = 0; i < str.length - 1; i++){}
 * Your program has a logical flaw in the loop inside the searchWordInStr method. Here are the key issues:
 *
 * Overwriting foundMessage: Inside the loop, foundMessage is overwritten during every iteration, even if the word has already been found. This causes the program to potentially return "Not found" even if the word exists in the array.
 * Loop Bound Issue: The condition i < str.length - 1 excludes the last element of the str array, so it won't check if the word is present at the last position.
 */