package com.stream.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        //String[] str = {"amazon", "amazonia","amazoniza"};
        String[] str = {"spring", "springboot","spr"};

        String resultByStream = findLongestCommonPrefixUsingStream(str);
        System.out.println(resultByStream);
        String resultByBruteForce = findLongestCommonPrefixBruteForce(str);
        System.out.println(resultByBruteForce);

    }

    private static String findLongestCommonPrefixUsingStream(String[] str) {

        if(str == null || str.length ==0)
            return "";

        String shortest = Arrays.stream(str).min(Comparator.comparingInt(String::length)).orElse("");
        //System.out.println(shortest);

        return Arrays.stream(str).reduce(shortest, LongestCommonPrefix::apply);
    }

    private static String findLongestCommonPrefixBruteForce(String[] str) {

        if(str == null || str.length ==0)
        return "";


        String prefix = str[0];


        for(int i = 1; i <str.length; i++){
            //str[i].indexOf(prefix) != 0  . its also ok
            while(! str[i].startsWith(prefix)){

                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    private static String apply(String prefix, String current) {

        while (!current.startsWith(prefix)) {


            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.length() == 0)
                return "";
        }
        return prefix;

    }
}
/**
 *
 * Logic Explanation:
 * Initialization:
 *
 * The first string in the array (str[0]) is taken as the initial prefix.
 * Iterate Over Strings:
 *
 * Loop through the rest of the strings in the array (from index 1 onwards).
 * Check Prefix in Current String:
 *
 * Use the indexOf method to check if the prefix exists at the beginning of the current string (str[i]).
 * If str[i].indexOf(prefix) != 0, it means prefix is not a prefix of str[i].
 * Shorten the Prefix:
 *
 * Remove the last character of the prefix (reduce its length by 1) using substring and repeat the check until a match is found or the prefix becomes empty.
 * Return Result:
 *
 * If the prefix becomes empty, return an empty string ("").
 * Otherwise, after the loop, the remaining prefix is the longest common prefix of all strings.
 *
 *
 * The line prefix = prefix.substring(0, prefix.length() - 1); is used to progressively shorten the prefix by removing one character from the end. This step is part of the logic to ensure the prefix remains a common prefix among the strings being compared.
 *
 * Detailed Explanation:
 * Purpose:
 *
 * The goal of the program is to find the longest common prefix among all strings in the array.
 * If the current prefix is not a prefix of a particular string, it needs to be shortened until it becomes a valid prefix of that string.
 * Why Substring?:
 *
 * If prefix is not a prefix of the current string (i.e., !strings[i].startsWith(prefix)), the mismatch is likely due to one or more characters at the end of prefix that do not match the beginning of the current string.
 * By removing the last character of prefix (using substring), the method systematically tries shorter versions of prefix until it finds one that matches or the prefix becomes empty.
 * How It Works:
 *
 * prefix.substring(0, prefix.length() - 1) creates a new string that contains all characters of prefix except the last one.
 * For example:
 * If prefix is "flower", the first shortening results in "flowe", then "flow", and so on.
 * When This Happens:
 *
 * This step occurs inside a while loop, which continues until the prefix matches the beginning of the current string (strings[i]).
 * If the prefix becomes empty (""), it means no common prefix exists among the strings.
 * Example Walkthrough:
 * Input: ["flower", "flow", "flight"]
 * Initial prefix: "flower" (first string).
 * Compare prefix ("flower") with strings[1] ("flow"):
 *
 * "flower".startsWith("flow") is false, so shorten:
 * prefix = "flower".substring(0, 6 - 1) → "flowe"
 * "flowe".startsWith("flow") is false, so shorten again:
 * prefix = "flowe".substring(0, 5 - 1) → "flow"
 * "flow".startsWith("flow") is true.
 * Compare updated prefix ("flow") with strings[2] ("flight"):
 *
 * "flow".startsWith("fli") is false, so shorten:
 * prefix = "flow".substring(0, 4 - 1) → "flo"
 * "flo".startsWith("fli") is false, so shorten again:
 * prefix = "flo".substring(0, 3 - 1) → "fl"
 * "fl".startsWith("fli") is true.
 * Final prefix: "fl".
 * Key Takeaways:
 * The line systematically reduces the prefix one character at a time from the end, allowing the program to converge toward the correct longest common prefix or determine that none exists.
 *
 *
 *
 *
 *
 *
 * Reduce method logic:-
 *
 * The reduce method and the logic involving shortestString in the corrected code are central to understanding how the longest common prefix is computed. Here's a detailed explanation:
 *
 * 1. Logic of shortestString:
 * java
 * Copy code
 * String shortestString = Arrays.stream(str).min((a, b) -> a.length() - b.length()).orElse("");
 * Purpose:
 *
 * The longest common prefix cannot be longer than the shortest string in the array because any prefix longer than the shortest string would automatically fail to match it.
 * Hence, we start with the shortest string as a candidate for the longest common prefix.
 * How It Works:
 *
 * Arrays.stream(str): Creates a stream of strings from the array str.
 * .min((a, b) -> a.length() - b.length()): Finds the shortest string by comparing the lengths of strings (a and b) in the array. The comparator returns the string with the smallest length.
 * .orElse(""): Ensures that if the array is empty, the method returns an empty string ("").
 * Example:
 *
 * Input: ["flower", "flow", "flight"]
 * Shortest string: "flow"
 * 2. Logic of reduce Method:
 * java
 * Copy code
 * String commonPrefix = Arrays.stream(str)
 *     .reduce(shortestString, (prefix, current) -> {
 *         while (!current.startsWith(prefix)) {
 *             prefix = prefix.substring(0, prefix.length() - 1);
 *             if (prefix.isEmpty()) {
 *                 return "";
 *             }
 *         }
 *         return prefix;
 *     });
 * Purpose:
 *
 * The reduce method iteratively compares the prefix (starting with the shortest string) against each string in the array (current) and reduces the prefix to the longest substring that is common across all strings.
 * How It Works:
 *
 * Initial Value (shortestString):
 *
 * The reduce method starts with shortestString as the initial value for the prefix.
 * Comparison and Reduction:
 *
 * For each string in the array (current), check if the current string starts with the prefix:
 * If current.startsWith(prefix) is false, the prefix is shortened by removing the last character using prefix.substring(0, prefix.length() - 1).
 * Repeat until current starts with the prefix or prefix becomes empty.
 * Return the Reduced Prefix:
 *
 * After comparing all strings, the reduced prefix is returned as the result.
 * Parameters:
 *
 * prefix: The current common prefix being checked. Initially set to shortestString and progressively reduced if mismatches occur.
 * current: The current string in the array being compared with prefix.
 * 3. Example Walkthrough:
 * Input: ["flower", "flow", "flight"]
 * Initial shortestString: "flow" (shortest string in the array).
 *
 * Stream Iteration:
 *
 * First Comparison (prefix = "flow", current = "flower"):
 *
 * "flower".startsWith("flow") → true.
 * No changes to prefix.
 * Second Comparison (prefix = "flow", current = "flight"):
 *
 * "flight".startsWith("flow") → false.
 * Shorten prefix:
 * "flow".substring(0, 4 - 1) → "flo"
 * "flight".startsWith("flo") → false
 * "flo".substring(0, 3 - 1) → "fl"
 * "flight".startsWith("fl") → true.
 * Final prefix for this iteration: "fl".
 * Result: "fl" (common prefix for all strings).
 *
 * Key Points:
 * What prefix Contains:
 *
 * It holds the currently assumed longest common prefix. It starts as the shortest string and is progressively shortened if mismatches are found.
 * What current Contains:
 *
 * It holds the string currently being compared to prefix in each iteration of the stream.
 * How They Work Together:
 *
 * prefix is updated based on its compatibility with current until it is the longest prefix common to all strings.
 *
 */