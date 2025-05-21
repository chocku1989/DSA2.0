package org.training;

public class Solution {
    public static int solve(int A) {

        String num=Integer.toString(A);
        int ans=0;
        for(int i=0;i<num.length();i++){
            int currDigit=num.charAt(i) - '0';
            int n=num.length()-i-1;
            if(currDigit>1){
                ans+= Math.pow(10,n) + (currDigit * (n *  Math.pow(10,n-1)));

            }else  if(currDigit==1){
                if(i<num.length()-1) {
                    int remNum=Integer.parseInt(num.substring(i+1));
                    ans+= remNum +1 + (currDigit * (n *  Math.pow(10,n-1)));
                }else {
                    ans+=1;
                }
            }


        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(18));
    }
}
