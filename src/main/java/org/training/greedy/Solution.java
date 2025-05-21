package org.training.greedy;

import java.util.*;

class Inventory {
    int expiry;
    int profit;

    public Inventory(int expiry, int profit) {
        this.expiry = expiry;
        this.profit = profit;
    }



}

public class Solution {

    int mod = (int) (Math.pow(10, 9) + 7);
    List<Inventory> invList = new ArrayList<>();

    public int solve(int[] A, int[] B) {

        int i = 0;
        while (i < A.length) {
            invList.add(new Inventory(A[i], B[i]));
            i++;
        }

        Collections.sort(invList, new Comparator<Inventory>() {
            @Override
            public int compare(Inventory inv1, Inventory inv2) {
                if (inv1.expiry == inv2.expiry) {
                    return inv2.profit - inv1.profit;
                }
                return inv1.expiry - inv2.expiry;
            }

        });

        Queue<Integer> profitMinHeap = new PriorityQueue<>();

        int time = 0;
        int profit = 0;
        for (Inventory inv : invList) {
            if (inv.expiry > time) {
                profit += inv.profit;
                profitMinHeap.add(inv.profit);
                time++;
            } else if (profitMinHeap.peek() < inv.profit) {
                int min = profitMinHeap.poll();
                profit -= min;
                profit += inv.profit;
                profitMinHeap.add(inv.profit);
            }
            profit = profit % mod;
        }
        return (profit % mod);
    }


    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println( s.solve(new int [] {2, 4, 3, 5} , new int [] {100, 200, 300, 400} ));

    }


}
