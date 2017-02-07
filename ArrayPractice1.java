public class ArrayPractice1 {

	// A lot of questions arise from this problem. Can we have a variable keeping track of the current position? Can we create a new object to
	// represent the array? If so, I would use a Linked List.
	
	// public static boolean hasNext() {



	// }

	// public static int[] next() {

	// }

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

	public static int[][] removeElement(int[][] arrayArray, int elementPos) {
		int[][] newArray = new int[arrayArray.length-1][];
		System.arraycopy(arrayArray, 0, newArray, 0, elementPos);
		int numElements = arrayArray.length - (elementPos - 1);
		// System.arraycopy copies from the initial array
		if (arrayArray.length != elementPos) {
			System.arraycopy(arrayArray, elementPos + 1, newArray, elementPos, numElements);
		}
		return arrayArray;
	}

	public static void main(String args[]) {
		int[][] arrayOfIntArrays = new int[][]{{}, {1,2,3}, {4,5}, {}, {}, {6,7}, {8}, {9,10}};
		System.out.println(arrayOfIntArrays.length);
		printEachArray(arrayOfIntArrays);
		int[][] newArray = removeElement(arrayOfIntArrays, 0);
		System.out.println(newArray.length);
		printEachArray(arrayOfIntArrays);
		newArray = removeElement(newArray, newArray.length-1);
		printEachArray(arrayOfIntArrays);
	}


}