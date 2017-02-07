public class SquaredRoot {

    public static boolean squareRoot(int number) {
        if( number == 0 ) {
            return true;
        }
        else if (number % 2 == 0 ){
            int number2 = number/2;
            if ( number2 == 1 || number2 == -1) {
                return true;
            }
            else {
                return squareRoot(number2);
            }
        }
        else {
            return false;
        }

    }

    // Currently at a problem where we never enter the first if statement
    // when number is 0 because 2/2 is 1.
    public static void main(String args[]) {

        System.out.println(squareRoot(0));
        System.out.println(squareRoot(1));
        System.out.println(squareRoot(2));
        System.out.println(squareRoot(3));
        System.out.println(squareRoot(1024));
        System.out.println(squareRoot(1023));
        System.out.println(squareRoot(-1));
        System.out.println(squareRoot(-2));
        System.out.println(squareRoot(-4));

    }

}

