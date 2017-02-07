import java.io.*;
import java.util.*;

public class Solution2 {

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

	public static void main(String[] args) {
		int[][] testArray = new int[][]{{1,2,3}};
		int[][] testArray1 = new int[][]{{},{1,2,3},{4,5},{6},{},{7,8,9}};
		int[][] testArray2 = new int[][]{{},{},{},{}};
		int[][] testArray3 = new int[][]{{},{1},{},{},{2}};

		printEachArray(testArray1);

		MyArrayIterator iterator = new MyArrayIterator(testArray1);

		iterator.next();

		iterator.remove();

		printEachArray(testArray1);

		// MyArrayIterator iterator2 = new MyArrayIterator(testArray1);



		// System.out.println(iterator2.hasNext());
		// while (iterator2.hasNext()) {
		// 	System.out.println(iterator2.next());
		// }


		// MyArrayIterator iterator = new MyArrayIterator(testArray);
		// System.out.println(iterator.hasNext());
		// System.out.println(testArray[0].length);
		// System.out.println(iterator.next());
	}



}

class MyArrayIterator {

	private int[][] myArray;
	private int currentElement;
	private int currentArray;
	private boolean canRemove;

	public MyArrayIterator(int[][] array) {
		myArray = array;
		currentElement = 0;
		currentArray = 0;
		canRemove = true;
	}

	private int[] getNextPosition() {
		int tempArrayPos = currentArray;
		int tempElementPos = currentElement;

		if (tempElementPos < myArray[tempArrayPos].length - 1) {
			tempElementPos++;
		} else {
			tempElementPos = 0;
			tempArrayPos++;
		}

		// Skips null arrays
		while (tempArrayPos < myArray.length && myArray[tempArrayPos].length == 0) {
			tempArrayPos++;
			tempElementPos = 0;
		}

		// System.out.println(tempArrayPos + " " + tempElementPos);

		if (tempArrayPos != myArray.length) {
			return new int[]{tempArrayPos,tempElementPos};
		}
		return new int[]{-1,-1};
	}

	public boolean hasNext() {

		int[] coordinate = getNextPosition();

		if (coordinate[0] == -1) {
			return false;
		}

		return true;

	}

	public int next() {
		int[] coordinate = getNextPosition();
		if (coordinate[0] == -1) {
			throw new NoSuchElementException();
		} else {
			// Should be getting set
			currentArray = coordinate[0];
			currentElement = coordinate[1];
			canRemove = true;
			return myArray[currentArray][currentElement];
		}
	}

	public void remove() {
		if (canRemove) {
			if (myArray[currentArray].length != 0) {
				int[] newArray = new int[myArray[currentArray].length - 1];
				System.arraycopy(myArray[currentArray], 0, newArray, 0, currentElement);
				System.arraycopy(myArray[currentArray], currentElement + 1, newArray, currentElement, (myArray[currentArray].length - currentElement - 1));
				myArray[currentArray] = newArray;
			} else {
				canRemove = false;
				throw new IllegalStateException("Can't remove from empty array");
			}
		} else {
			throw new IllegalStateException();
		}

	}
}