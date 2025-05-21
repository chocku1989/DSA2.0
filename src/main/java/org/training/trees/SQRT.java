package org.training.trees;

public class SQRT {
    public static int countMinSquares(int A) {

        int dp[] = new int[A + 1];
        dp[0] = 0;
        for (int i = 1; i <= A; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                ans = Math.min(ans, dp[i - j * j]);
            }
            dp[i] = ans + 1;
        }
        return dp[A];
    }

    public static int countMinSquares1(int A) {

//        int dp [] = new int [A+1];


//        dp[0]=0;
        int ans = 0;
        for (int i = 1; i <= A; i++) {
            ans = Integer.MAX_VALUE;
            int temp = i;
            for (int j = 1; j * j <= i; j++) {
                ans = Math.min(ans, temp - j * j);
            }

//            dp [i]=ans+1;

        }
        return ans + 1;

    }

    public static void main(String[] args) {
        System.out.println(countMinSquares(12));
    }
}
