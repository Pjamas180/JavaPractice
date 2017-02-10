import java.lang.String;
import java.lang.StringBuilder;

public class Palindrome {

	public static boolean palindrome( String s ) {
		String copy = s;
		copy = copy.replaceAll("\\W+", "");
		System.out.println("The first string without symbols: " + copy);
		String copy1 = new StringBuilder(copy).reverse().toString();
		copy = copy.toLowerCase();
		copy1 = copy1.toLowerCase();
		System.out.println("The string reversed: " + copy1);
		return copy.equals(copy1);
	}

	// This algorithm takes O(n^2) time because we are searching for a valid palindrome
	// from each point in n until the string that is being validated is at most n.
	public static String longestPalindrome(String input) {
		int length = input.length();
		boolean[][] table = new boolean[length][length];

		for (int i = 0; i < length; i++) {
			table[i][i] = true;
		}

		// Initializing starting point for longest palindrome
		int start = 0;
		int maxLength = 0;
		for (int i = 0; i < length - 1; i++) {
			if (input.charAt(i) == input.charAt(i+1)) {
				table[i][i+1] = true;
				start = i;
				maxLength = 2;
			}
		}

		for (int k = 3; k <= length; k++) {
			for (int i = 0; i < length-k+1; i++) {
				int j = i + k - 1;
				if (table[i+1][j-1] && input.charAt(i) == input.charAt(j)) {
					table[i][j] = true;
					if (k > maxLength) {
						maxLength = k;
						start = i;
					}
				}
			}
		}

		return input.substring(start, start + maxLength);

	}

	public static void main( String[] args ) {
		String racecar = "No 'x' in N...ixoßßåΩn";
		boolean b = palindrome (racecar);
		System.out.println(b);

		String thisIsATest = "1234thisisatesttsetasisiht1234";
		System.out.println(longestPalindrome(thisIsATest));
	}
}