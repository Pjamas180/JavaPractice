import java.util.*;

public class StringRemainder {


    public static String getRemainder( int index, String input ) {
        return input.substring(index, input.length() );
    }

    public static int getIndexWhereLongestSequence( String input ) {

        char match = input.charAt(0);
        int longestLength = 1;
        int inARow = 1;
        int position = 0;
        int currentPosition = 0;
        for( int i = 1; i < input.length(); i++ ) {
            if (match == input.charAt(i)) {
                inARow++;
            } else {
                match = input.charAt(i);
                if( inARow > longestLength ) {
                    longestLength = inARow;
                    position = currentPosition;
                }
                currentPosition = i;
                inARow = 1;
            }
        }
        // Fixes corner case for when the last sequence of letters is the 
        // longest sequence.
        if( inARow > longestLength ) {
            position = currentPosition;
        }
        return position;

    }

    public static void main( String[] args ) {
        
        // test cases
        String apple = "apple";
        String banana = "banana";
        String orange = "orange";

        System.out.println( getRemainder( 3, apple ));
        System.out.println( getRemainder( 4, banana ));
        System.out.println( getRemainder( 2, orange ));

        String aabbbbaa = "aabbbbbbbbbaaaaaa";
        System.out.println( getIndexWhereLongestSequence( aabbbbaa ));

    }
}
