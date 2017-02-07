import java.util.HashMap;

public class NoDuplicates {

	public static int noDuplicates( int[] array ) {
		HashMap <Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int current = array[0];
		for (int i : array) {
			if (map.get(i) == null) {
				map.put(i, true);
				current = i;
			}
			else {
				map.put(i, false);
			}
		}
		return current;
	}

	public static void main ( String[] args ) {

		String inputArray = args[1];
		
        String[] parts = inputArray.split(" ");
        int[] n1 = new int[parts.length];
        for(int n = 0; n < parts.length; n++) {
            n1[n] = Integer.parseInt(parts[n]);
        }

		int current = noDuplicates(n1);
		System.out.println(current);

	}
}
