import java.io.*;
import java.util.*;


/** 
 * Problem is based off following xkcd:
 * https://xkcd.com/287/
 * I am solving for the possible sets of appetizers adding up to a given cost.
 */
public class MenuOfAppetizersSolution {

	private static void printEachArray(int[][] arrays) {
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

		double price = 15.05;

		HashMap<String, Double> menu = new HashMap<String, Double>();

		menu.put("Sampler", 5.80);
		menu.put("Sticks", 4.20);
		menu.put("Wings", 3.55);
		menu.put("Salad", 3.35);
		menu.put("Fries", 2.75);
		menu.put("Fruit", 2.15);

		ArrayList<Double> values = menu.values();

		Set<String> items = menu.keySet();

		// Converted into integers so it is easier to understand for me
		int priceAsInt = 1505;
		int[] menuItemsPrices = {580, 420, 355, 335, 275, 215};
		

		HashMap<Double, Integer> numberOfWaysForEachPrice = new HashMap<Double, Integer>();

		int[] counts = new int[menuItemsPrices.length];
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		getNumberOfEachItem(menuItemsPrices, counts, 0, priceAsInt, lists);
		for (ArrayList<Integer> list : lists) {
			int index = 0;
			for (String item : menu.keySet()) {
				System.out.print(item + ": " + list.get(index) + ". ");
				index++;
			}
			System.out.println();
		}


	}

	public static void getNumberOfEachItem(int[] menu, int[] counts,
		int startIndex, int totalAmount, ArrayList<ArrayList<Integer>> lists) {

		if (startIndex >= menu.length) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int in = 0; in < counts.length; in++) {
				list.add(counts[in]);
			}
			lists.add(list);
			return;
		}

		if (startIndex == menu.length-1) {
			if (totalAmount%menu[startIndex] == 0) {
				counts[startIndex] = totalAmount/menu[startIndex];
				getNumberOfEachItem(menu, counts, startIndex + 1, 0, lists);
			}
		}
		else {
			for (int i = 0; i <= totalAmount/menu[startIndex]; i++) {
				counts[startIndex] = i;
				getNumberOfEachItem(menu, counts, startIndex + 1, totalAmount - menu[startIndex]*i, lists);
			}
		}
		return;
	}

	
}