package com.hahahey.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {
    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};


        int[] twoNumSum ;
        twoNumSum = getTwoNumSum(arr, 27);

        for (int i = 0; i < twoNumSum.length; i++) {
            System.out.println(twoNumSum[i]);
        }


    }

    public static int[] getTwoNumSum(int[] arr, int sumNum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int ele = sumNum - arr[i];
            if (map.containsKey(ele)) {
                return new int[]{map.get(ele), i};
            }
            map.put(arr[i], i);

        }
        throw new IllegalArgumentException("No two number fit this method");
        //return new int[2];
    }


}
