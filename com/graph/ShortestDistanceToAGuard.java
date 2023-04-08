package com.graph;

public class ShortestDistanceToAGuard {

    public static void main(String[] args) {
        char matrix[][] = {{'O', 'O', 'O', 'O', 'G'},
                           {'O', 'W', 'W', 'O', 'O'},
                           {'O', 'O', 'O', 'W', 'O'},
                           {'G', 'W', 'W', 'W', 'O'},
                           {'O', 'O', 'O', 'O', 'G'}};

        ShortestDistanceToAGuard g = new ShortestDistanceToAGuard();
        g.findDistance(matrix);
    }

    public void findDistance(char[][] matrix) {
       
    }
}
