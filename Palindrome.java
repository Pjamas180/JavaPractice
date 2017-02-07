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

	public static void main( String[] args ) {
		String racecar = "No 'x' in N...ixoßßåΩn";
		boolean b = palindrome (racecar);
		System.out.println(b);
	}
}