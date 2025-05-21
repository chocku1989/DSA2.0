package org.training.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInMazeImprovised {

    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    private static class Point {
        int row, col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int solve(int[][] maze, int[] src, int[] dest) {
        int n = maze.length, m = maze[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(src[0], src[1]));
        dist[src[0]][src[1]] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int r = cur.row, c = cur.col, steps = 0;

                // Roll the ball until it hits a wall
                while (isValid(r + DX[d], c + DY[d], maze)) {
                    r += DX[d];
                    c += DY[d];
                    steps++;
                }

                if (dist[cur.row][cur.col] + steps < dist[r][c]) {
                    dist[r][c] = dist[cur.row][cur.col] + steps;
                    queue.offer(new Point(r, c));
                }
            }
        }

        return( dist[dest[0]][dest[1]]==Integer.MAX_VALUE? -1:dist[dest[0]][dest[1]]);
    }

    private boolean isValid(int r, int c, int[][] maze) {
        return r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] == 0;
    }

    public static void main(String[] args) {
        ShortestDistanceInMazeImprovised solver = new ShortestDistanceInMazeImprovised();

        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] destination = {4, 4};

        System.out.println("Shortest distance: " + solver.solve(maze, start, destination));
    }
}
