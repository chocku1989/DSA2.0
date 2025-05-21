package org.training.graphs;


import java.util.ArrayList;
import java.util.Arrays;

public class DFS {

    public int solve(int A, int[][] B) {

        ArrayList<ArrayList<Integer>> adjList = createAdjList(B);
        boolean[] visited = new boolean[A + 1];
        Arrays.fill(visited, false);
        return DFS(1, adjList, A, visited);
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

    public int DFS(int startNode, ArrayList<ArrayList<Integer>> adjList, int target, boolean[] visited) {

        if (startNode == target) {
            return 1;
        }
        if (visited[startNode]) return 0;

        visited[startNode] = true;

        for (Integer child : adjList.get(startNode)) {
            if (!visited[child]) {
                if (DFS(child, adjList, target, visited) == 1)
                    return 1;
            }
        }
        // return DFS();
        return 0;


    }

    public int solve1(int A, int[][] B) {

        ArrayList<ArrayList<Integer>> adjList = createAdjList(B);
        boolean[] visited = new boolean[A + 1];
        Arrays.fill(visited, false);
        return DFSFindCycle(1, adjList, visited);
    }

    public int DFSFindCycle(int startNode, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {


        if (visited[startNode]) return 1;

        visited[startNode] = true;

        for (Integer child : adjList.get(startNode)) {
            if (DFSFindCycle(child, adjList, visited) == 1)
                return 1;
        }
        return 0;
    }
}
