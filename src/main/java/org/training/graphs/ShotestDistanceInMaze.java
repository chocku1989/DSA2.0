package org.training.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShotestDistanceInMaze  {
    class  Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }

    public int solve(int[][] maze, int[] src, int[] dest) {
        int n=maze.length;
        int m=maze[0].length;
        int[][] distance = new int [n][m];

        for(int i = 0; i < n ; i++) {
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }
        int srcRow=src[0];
        int srcCol=src[1];
        int destRow=dest[0];
        int destCol=dest[1];
        if(maze[destRow][destCol]==1) return -1;
        distance[srcRow][srcCol]=0;
        int [] x = {1,-1,0,0};
        int [] y = {0, 0,1,-1};

        Queue<Pair> queue = new LinkedList<>();
        queue.add( new Pair(srcRow,srcCol));

        while(!queue.isEmpty()){

            Pair re = queue.poll();

            for(int k = 0; k < 4 ; k++) {
                int count=0;
                int ni =re.row;
                int nj =re.col;

                while(ni+x[k]>=0 && ni+x[k]< n  && nj+y[k]>=0 && nj+y[k]< m && maze[ni+x[k]][nj+y[k]]==0 ){
                    ni+=x[k];
                    nj+=y[k];
                    count++;
                }
                int newDist = distance[re.row][re.col]+count;
                if(newDist<distance[ni][nj]){
                    distance[ni][nj]=newDist;
                    queue.offer(new Pair(ni,nj));
                }
            }
        }
        return( distance[destRow][destCol]==Integer.MAX_VALUE? -1:distance[destRow][destCol]);

    }

    public static void main(String[] args) {
        ShotestDistanceInMaze solution = new ShotestDistanceInMaze();

        // Test case
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] destination = {4, 4};

        int result = solution.solve(maze, start, destination);
        System.out.println("Shortest distance: " + result);
    }

}
