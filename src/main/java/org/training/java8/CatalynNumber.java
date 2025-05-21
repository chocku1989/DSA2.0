package org.training.java8;

public class CatalynNumber {

    public static int findNtthCatalynNumber(int n, int [] dp ){

        dp[0]=1;dp[1]=1;
        for(int i = 2; i <= n; i++) {
            for(int j=0;j<=i-1;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        int n=4;
        int  [] dp = new int [n+1];
        System.out.println(findNtthCatalynNumber(n,dp));
        CatalynNumber c= new CatalynNumber();
      System.out.println( "unique BST "  +c.numTrees(2));

    }


    public int numTrees(int A) {


        return findNthCatalynNumber(A);
    }


    public int findNthCatalynNumber(int n){
        if(n==0 || n==1) return 1 ;
        int x=0;
        int y=n-1;
        int ans =0;
        while(x<n){

            ans+=findNthCatalynNumber(x)*findNthCatalynNumber(y);

            x++;
            y--;
        }
        return ans;
    }
}
