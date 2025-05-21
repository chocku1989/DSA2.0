package org.training.dp;

public class MaxProduct {

    public static int maxProduct(final int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        }

        long ans = arr[0];
        long dpMax = arr[0];
        long dpMin = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int currNum = arr[i];
            long dpMin_local = Math.min(currNum, Math.min(currNum * dpMin, currNum * dpMax));
            dpMax = Math.max(currNum, Math.max(currNum * dpMin, currNum * dpMax));
            dpMin = dpMin_local;

            ans = Math.max(ans, dpMax);
        }
        return (int) ans;

    }

    public static void main(String[] args) {

        System.out.println(maxProduct(new int[]{-4, 0, -5, 0}));

    }
}
