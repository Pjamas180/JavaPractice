import java.util.*;

public class ArrayArray<T extends List<Integer>> extends LinkedList<T> {

	private int position;

	public ArrayArray() {
		super();
		position = 0;

	}

	public boolean hasNext() {
		if (position == this.size() - 1) {
			return false;
		}
		return true;
	}

	public T next() {
		if (hasNext()) {
			position++;
			return this.get(position);
		}
		throw new IndexOutOfBoundsException("Index out of range.");
	}

	public T remove(int place) {
		return super.remove(place);
	}

	public LinkedList<Integer> combineElementArrays() {
		LinkedList<Integer> combinedElements = new LinkedList<Integer>();
		for (int i = 0; i < size(); i++) {
			for (int j = 0; j < get(i).size(); j++) {
				combinedElements.add(get(i).get(j));
			}
		}
		return combinedElements;
	}

	public static int[] removeElement(int[][] arrayArray, int elementPos) {

		int[][] newArray = new int[arrayArray.length-1][];

		int[] result = arrayArray[elementPos];

		int numElements = arrayArray.length - (elementPos + 1);
		System.arraycopy(arrayArray, elementPos + 1, arrayArray, elementPos, numElements);


		return result;
	}

	public static void printIntArrayValues(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String args[]) {
		
		int[][] arrayOfInts = new int[][]{{1,2,3},{},{4,5,6},{7,8,9}};

		int[] removed = removeElement(arrayOfInts, 2);

		printIntArrayValues(removed);
		System.out.println();

		// printIntArrayValues(arrayOfInts[0]);
		// printIntArrayValues(arrayOfInts[1]);
		// printIntArrayValues(arrayOfInts[2]);
		// printIntArrayValues(arrayOfInts[3]);

		System.out.println(arrayOfInts[8]);

	}
	
}