package org.training.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public int solve(int A, int[][] B) {

        ArrayList<ArrayList<Integer>> adjList = createAdjList(B);
        return BFS(adjList, A);
    }


    public ArrayList<ArrayList<Integer>> createAdjList(int[][] B) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            while (adjList.size() <= u) {
                adjList.add(new ArrayList<Integer>());
            }

            adjList.get(u).add(v);
        }
        return adjList;

    }

    public int BFS(ArrayList<ArrayList<Integer>> adjList, int target) {

        Queue<Integer> bfsQueue = new ArrayDeque<>();
        boolean[] visited = new boolean[target];
        Arrays.fill(visited, false);
        bfsQueue.add(1);

        while (!bfsQueue.isEmpty()) {

            if (bfsQueue.peek() == target) {
                return 1;
            } else {
                int curr = bfsQueue.poll();
                if (!visited[curr]) {
                    visited[curr] = true;
                    bfsQueue.addAll(adjList.get(curr));
                }
            }
        }
        return 0;
    }
}
