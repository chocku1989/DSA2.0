package org.training.arrays;

import java.util.Arrays;

public class Solution {


    public int solve(int[] value, int[] weight, int capacity) {

        int[][] dp = new int[value.length + 1][capacity];

        for (int i = 0; i <= value.length; i++) {
            Arrays.fill(dp[i], -1);

        }


        return findMax(value, weight, value.length, capacity, 0, dp);

    }


    int findMax(int[] value, int[] weight, int index, int capacity, int currentWeight, int[][] dp) {

        if (index == 0) return 0;
        if (currentWeight >= capacity) return 0;

        if (dp[index][currentWeight] != -1) {
            return dp[index][currentWeight];
        }

        int val1 = findMax(value, weight, index - 1, capacity, currentWeight, dp);
        int val2 = 0;
        if ((currentWeight + weight[index - 1]) <= capacity)
            val2 = findMax(value, weight, index - 1, capacity, currentWeight + weight[index - 1], dp) + value[index - 1];
        dp[index][currentWeight] = Math.max(val1, val2);
        return dp[index][currentWeight];


    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
//        int[] value1 = {60, 100, 120};
//        int[] weight1 = {10, 20, 30};
//        int capacity1 = 50;
//        System.out.println("Test Case 1: " + sol.solve(value1, weight1, capacity1)); // Expected: 220

        // Test Case 2
        int[] value2 = {60, 100, 120, 80, 90, 110, 70, 85, 95, 105, 75, 65, 55, 45, 35, 25, 15, 5, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300, 310, 320};
        int[] weight2 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 5, 15, 25, 35, 45, 55, 65, 75, 85, 95, 12, 22, 32, 42, 52, 62, 72, 82, 92, 102, 7, 17, 27, 37, 47, 57, 67, 77, 87, 97, 13, 23, 33, 43, 53, 63, 73, 83, 93, 103};
        int capacity2 = 1000;
        System.out.println("Test Case 2: " + sol.solve(value2, weight2, capacity2)); // Expected: 0
    }


}
