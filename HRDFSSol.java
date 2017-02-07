import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int getBiggestRegion(int[][] matrix) {
        int biggestRegion = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentBiggestRegion = 0;
                // If the cell is a one, conduct dfs
                if (matrix[row][col] == 1) {
                    matrix[row][col] = 0;
                    currentBiggestRegion = dfsBiggestRegion(matrix, row, col, currentBiggestRegion);
                }
                if (currentBiggestRegion > biggestRegion) {
                    biggestRegion = currentBiggestRegion;
                }
            }
        }
        return biggestRegion;
    }
    
    private static int dfsBiggestRegion(int[][] matrix, int row, int col, int currentBiggestRegion) {
        for (int i = -1; i <=1; i++) {
            for (int j = -1; j <=1; j++) {
                if (row + i < 0 || row + i >= matrix.length || col + j < 0 || col + j >= matrix[row].length) {
                    continue;
                } else {
                    if (matrix[row + i][col + j] == 1) {
                        matrix[row + i][col + j] = 0;
                        currentBiggestRegion = dfsBiggestRegion(matrix, row + i, col + j, currentBiggestRegion);
                    }
                }
            }
        }
        return ++currentBiggestRegion;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        // System.out.println(grid.length);
        // System.out.println(grid[0].length);
        System.out.println(getBiggestRegion(grid));
    }
}
