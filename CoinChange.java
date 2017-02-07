import java.util.Arrays;

public class CoinChange {
  
  public static long countWays(int S[], int amountOfCoins, int n) {
    // Time complexity of this function: O(mn)
    // Space complexity of this function: O(n)

    // tablie[i] will be storing the number of solutions
    // for value i. We need n+1 rows as the table is 
    // constructed in bottom up manner using the base
    // case (n == 0)
    long[] table = new long[n+1];

    // Initialize all values to 0
    Arrays.fill(table, 0);

    // Base case (If given value is 0)
    table[0] = 1;

    // Pick all coins one by one and update the table[]
    // values after the index greater than or equal to
    // the value of the picked coin
    for (int i = 0; i < amountOfCoins; i++) {
      for (int j = S[i]; j <= n; j++) {
        table[j] += table[j-S[i]];
      }
    }

    return table[n];

  }


  public static void printCombinations(int[] coins, int[] counts, int startIndex, int totalAmount) {
    if(startIndex>=coins.length) {
      for(int i = 0; i < coins.length; i++)
        System.out.print(""+counts[i]+"*"+coins[i]+"+");
      System.out.println();
      return;
    }

    if(startIndex == coins.length-1) {
      if(totalAmount%coins[startIndex]==0) {
        counts[startIndex] = totalAmount/coins[startIndex];
        printCombinations(coins, counts, startIndex+1, 0);
      }
    } else {
      for(int i = 0; i <= totalAmount/coins[startIndex]; i++) {
        counts[startIndex] = i;
        printCombinations(coins, counts, startIndex+1, totalAmount-coins[startIndex]*i);
      }
    }
  }

  // Driver Function to test above function
  public static void main(String args[]) {
    
    int coins[] = {25, 10, 5, 1};
    int n = 25;
    System.out.println(countWays(coins, coins.length, n));
    
    System.out.println("############################");
    System.out.println("############################");
    System.out.println("############################");
    System.out.println("############################");

    int[] counts = new int[coins.length];
    printCombinations(coins, counts, 0, n);



  }

}