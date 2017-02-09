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


		Set<String> items = menu.keySet();

		// Converted into integers so it is easier to understand in calculations.
		int priceAsInt = 1505;
		int[] menuItemsPrices = {580, 420, 355, 335, 275, 215};

		System.out.println("~~NEW WAY~~");

		ArrayList<Integer> counts = new ArrayList<Integer>();
		for (int i = 0; i < menuItemsPrices.length; i++) {
			counts.add(0);
		}
		ArrayList<ArrayList<Integer>> listResult = new ArrayList<ArrayList<Integer>>();
		getNumberOfEachItem(menuItemsPrices, counts, priceAsInt, listResult);
		printListResult(listResult, items);

		System.out.println("~~OLD WAY~~");

		int[] counts1 = new int[menuItemsPrices.length];
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		getNumberOfEachItem2(menuItemsPrices, counts1, 0, priceAsInt, lists);
		printListResult(lists, items);

	}

	private static void printListResult(ArrayList<ArrayList<Integer>> lists, Set<String> items) {
		for (ArrayList<Integer> list : lists) {
			int index = 0;
			for (String item : items) {
				System.out.print(item + ": " + list.get(index) + ". ");
				index++;
			}
			System.out.println();
		}
	}

	public static void getNumberOfEachItem(int[] menu, ArrayList<Integer> counts, int totalAmount, 
		ArrayList<ArrayList<Integer>> listOfCounts) {

		if (totalAmount == 0) {
			listOfCounts.add(counts);
			return;
		}

		// We want to loop through the menu items and check price satisfies amount we have
		for (int i = 0; i < menu.length; i++) {
			if (totalAmount - menu[i] >= 0) {
				counts.set(i, counts.get(i)+1);
				getNumberOfEachItem(menu, new ArrayList<Integer>(counts), totalAmount - menu[i], 
					listOfCounts);
				counts.set(i, counts.get(i)-1);
			}
		}
		
	}

	/**
	 * Algorithm does not utilize Dynamic Programming and Memoization as opposed to
	 * getting the number of ways to reach a certain amount. This is so we can
	 * attain the possible combinations until a certain amount
	 */
	public static void getNumberOfEachItem2(int[] menu, int[] counts,
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
				getNumberOfEachItem2(menu, counts, startIndex + 1, 0, lists);
			}
		}
		else {
			for (int i = 0; i <= totalAmount/menu[startIndex]; i++) {
				counts[startIndex] = i;
				getNumberOfEachItem2(menu, counts, startIndex + 1, totalAmount - menu[startIndex]*i, lists);
			}
		}
		return;
	}

	
}