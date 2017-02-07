import java.util.*;

public class ArrayArrayPractice {

	// What is an array of arrays? How do you access it, how do you add elements to it, how do you delete elements from it?
	// What would be the best data structure to do all these?

	public static void printIntArrayValues(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void printEachArray(int[][] arrays) {
		for (int outerArray = 0; outerArray < arrays.length; outerArray++) {
			System.out.print("[");
			for (int innerArray = 0; innerArray < arrays[outerArray].length; innerArray++) {
				System.out.print(arrays[outerArray][innerArray]);
				if (innerArray != arrays[outerArray].length-1) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
			System.out.println();
		}
	}

	public static int[] combineIntArrays(int[][] arraysOfInts) {
		LinkedList<Integer> listOfInts = new LinkedList<Integer>();
		for (int outerCounter = 0; outerCounter < arraysOfInts.length; outerCounter++) {
			for (int innerCounter = 0; innerCounter < arraysOfInts[outerCounter].length; innerCounter++) {
				listOfInts.add(arraysOfInts[outerCounter][innerCounter]);
			}
		}
		int[] returnArray = new int[listOfInts.size()];
		for (int i = 0; i < listOfInts.size(); i++) {
			returnArray[i] = listOfInts.get(i);
		}
		return returnArray;
	}

	public static void main (String args[]) {
		// int[][] arraysOfInts = {new int[]{1, 2, 3}, new int[]{4, 5}, new int[]{}, new int[]{6}, new int[]{7, 8, 9}};

		int[][] arraysOfInts = {{3, 7, 1}, {6, 5}, {}, {2}, {4, 8, 9}};

		// for (int i = 0; i < arraysOfInts.length; i++) {
		// 	// I expect this to print out the locations in memory where the arrays exist. Hexadecimal space of 4 for each?
		// 	System.out.println(arraysOfInts[i]);
		// }
		// Let's print out the elements in the array
		printEachArray(arraysOfInts);

		// Let's combine the elements in an array to make one big array
		// If we want the numbers in order, we can place them in a min heap or max heap depending on the order wanted.
		// If order doesn't matter, but just put it together, we can put it into a data structure immediately. then possibly order it. this way has worse optimization.

		int[] combined = combineIntArrays(arraysOfInts);
		Arrays.sort(combined); // What is the runtime for this? O(nlog(n))?

		printIntArrayValues(combined);

	}

}