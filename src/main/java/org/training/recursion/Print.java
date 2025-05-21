package org.training.recursion;

public class Print {

    public void solve(int A) {
        print(A);
        System.out.println();
    }

    public void print(int A){
        if(A==0) return ;
        System.out.print(A +" ");
        print(A-1);
    }

    public static void main(String[] args){
        new Print().solve(10);
    }
}
