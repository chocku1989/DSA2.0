package org.training.twopointers;

import java.util.Arrays;

public class Numberline {
    public long findPairs(int[] A) {

        int right=A.length-1;
        int left=0;
        Arrays.sort(A);
        long count=0;

        while(left<right){

            int num1=A[left];
            int num2=A[right];

//            int leftRange=Math.min(Math.abs(num1-num2));
//            int rightRange=Math.max(Math.abs(num1+num2));
            int leftRange=0;
            int rightRange=0;

            if(leftRange>num1 && rightRange<num2 ){
                count++;
                right--;
                left++;

            }
            else if(leftRange<num1){
                left++;
            }else {
                right--;
            }

        }

        return count;
    }
}
