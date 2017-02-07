import java.io.*;
import java.util.*;
import java.text.*;
public class Solution {
    
    // Can we do this recursively? Meaning printing the outside first, then go inside...
    
    public static void printSpiralMatrix(String[][] matrix, boolean[][] seen, int xStartOrig, int xEndOrig, int yStartOrig, int yEndOrig, StringBuilder result) {
        // We need the starting and ending points to get smaller each iteration to mimic the spiral
        if (xStartOrig > xEndOrig || yStartOrig > yEndOrig) {
        	// Deletes final ", " of the string
        	result.deleteCharAt(result.length() - 1);
        	return;
        }
        int xStart = xStartOrig;
        int xEnd = xEndOrig;
        int yStart = yStartOrig;
        int yEnd = yEndOrig;
        for (; xStart < xEnd; xStart++) {
        	if (!seen[yStart][xStart]) {
        		seen[yStart][xStart] = true;
            	result.append(matrix[yStart][xStart] + ",");
            }
        }
        xStart--;
        yStart++;
        for (; yStart < yEnd; yStart++) {
        	if (!seen[yStart][xStart]) {
        		seen[yStart][xStart] = true;
            	result.append(matrix[yStart][xStart] + ",");
            }
        }
        yStart--;
        xStart--;
        for (; xStart >= xStartOrig; xStart--) {
        	if (!seen[yStart][xStart]) {
        		seen[yStart][xStart] = true;
            	result.append(matrix[yStart][xStart] + ",");
            }
        }
        xStart++;
        yStart--;
        for (; yStart > yStartOrig; yStart--) {
        	if (!seen[yStart][xStart]) {
        		seen[yStart][xStart] = true;
            	result.append(matrix[yStart][xStart] + ",");
            }
        }
        printSpiralMatrix(matrix, seen, xStartOrig + 1, xEndOrig - 1, yStartOrig + 1, yEndOrig - 1, result);
    }
    
    public static void main(String args[] ) throws Exception {
        
		Scanner in = new Scanner(System.in);
        String matrixSize = in.nextLine();
        String[] matrixSizes = matrixSize.split("[, ]+");
        String[][] matrix = new String[Integer.parseInt(matrixSizes[0])][Integer.parseInt(matrixSizes[1])];
        
        for (int i = 0; i < matrix.length; i++) {
            String elements = in.nextLine();
            matrix[i] = elements.split("[, ]+");
        }
        
        in.close();

        StringBuilder result = new StringBuilder();

        boolean[][] seen = new boolean[Integer.parseInt(matrixSizes[0])][Integer.parseInt(matrixSizes[1])];
        for (int i = 0; i < seen.length; i++) {
        	for (int j = 0; j < seen[i].length; j++) {
        		seen[i][j] = false;
        	}
        }
        
        printSpiralMatrix(matrix, seen, 0, matrix[0].length, 0, matrix.length, result);
        System.out.println(result.toString());
    }
}