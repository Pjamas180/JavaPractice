import java.util.Scanner;
import java.util.*;

public class InputPractice {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] stringArray = input.split(" ");
		int[] intArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}

		int negativeSubArrays = amountOfNegativeSubArrays(intArray);
		System.out.println(negativeSubArrays);

	}

	public static int amountOfNegativeSubArrays(int[] array){
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				int k = i;
				int l = j;
				int sum = 0;
				while (k <= l) {
					sum+=array[k];
					k++;
				}
				if (sum < 0) {
					count++;
				}
			}
		}
		return count;

	}


}