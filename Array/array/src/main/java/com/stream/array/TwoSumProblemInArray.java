package com.stream.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoSumProblemInArray {

    public static void main(String[] args) {

        int[] str = {4, 6, 8, 10, 0};
        int target = 10;

        List<int[]> pairByStream = findPairOfIndexWhoseSumEqualTargetByStream(str, target);
        pairByStream.forEach(e->System.out.println(e[0]+","+e[1]));
        List<int[]> pairByBruteForce = findPairOfIndexWhoseSumEqualTargetBruteForce(str, target);
        System.out.println("-----------------");
        pairByBruteForce.forEach(e->System.out.println(e[0]+","+e[1]));
    }

    private static List<int[]> findPairOfIndexWhoseSumEqualTargetBruteForce(int[] str,int target) {

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < str.length ; i++){
            for (int j = i + 1; j < str.length; j++) { // Start j from i + 1 to avoid duplicates
                if (str[i] + str[j] == target) {
                    list.add(new int[]{i, j}); // Add only one direction (i, j)
                }
            }
        }
        return list;
    }

    private static List<int[]> findPairOfIndexWhoseSumEqualTargetByStream(int[] str, int target) {


        // Handle edge cases
        if (str == null || str.length < 2) {
            return Collections.emptyList();
        }

        // Find pairs of indices whose elements sum up to the target

      return   IntStream.range(0, str.length).boxed().flatMap(i->IntStream.range(i + 1, str.length).filter(j->str[i] + str[j] == target).mapToObj(j->new int[]{i, j})).toList();




    }
}
