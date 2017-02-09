public class SumsOfCoins {


  public static boolean[] printSumsOfCoinsToMax(int[] coins, int max) {
    boolean[] sums = new boolean[max + 1];
    printSumsOfCoinsToMaxDynamicMemo(coins, max, 0, sums);
    return sums;
  }

  public static void printSumsOfCoinsToMaxDynamicMemo(int[] coins, int max, 
    int currentVal, boolean[] sums) {
    if (currentVal > max) {
      return;
    }
    
    for (int i = 0; i < coins.length; i++) {
      if (currentVal + coins[i] <= max && !sums[currentVal + coins[i]]) {
        sums[currentVal + coins[i]] = true;
        printSumsOfCoinsToMaxDynamicMemo(coins, max, currentVal + coins[i], sums);
      }
    }
  }
  
  public static void main(String[] args) {
    int[] coins = {10, 15, 55};
    int max = 1000;
    boolean[] result = printSumsOfCoinsToMax(coins, max);
    printValidResult(result);
  }

  private static void printValidResult(boolean[] result) {
    for (int i = 0; i < result.length; i++) {
      if (result[i]) {
       System.out.println(i);
      }
    }
  }

}