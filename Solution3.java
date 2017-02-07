import java.io.*;
import java.util.*;

public class Solution3 {

	public static void main(String[] args) {
		Integer[][] testArray = new Integer[][]{{},{1,2,3},{4,5,6},{7}};
		MyIterator iterator = new MyIterator(testArray);
	}


}


class MyIterator {

	private List<LinkedList<Integer>> myArray;
	private int position;
	private boolean canRemove;

	public MyIterator(Integer[][] array) {

	}

	private void convertArrayIntoList(Integer[][] array) {
		List<LinkedList<Integer>> converted = new LinkedList<LinkedList<Integer>>();
		for (int i = 0; i < array.length; i++) {
			LinkedList<Integer> newList = Arrays.asList(array[i]);
		}
	}

	public boolean hasNext() {
		return false;
	}

	public int next() {
		return 0;
	}

	public void remove() {

	}

}