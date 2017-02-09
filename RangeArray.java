public class RangeArray {

  public static String getRangeArray(int[] input) {
    StringBuilder result = new StringBuilder("(");

    int i = 0;
    if (input[i] != 1) {
      result.append("1-" + (input[i] - 1) + ",");
    } else {
      i++;
    }
    for (; i < input.length - 1; i++) {
      if (input[i] + 1 == 100) {
        continue;
      }
      // Takes care of the case where the numbers aren't next to eachother
      if (input[i+1] != input[i] + 1) {
        if (input[i+1]-1 != input[i] + 1) {
          result.append((input[i] + 1) + "-" + (input[i+1] - 1) + ",");
        } else {
          result.append((input[i]+1) + ",");
        }
      } else {
        // If they are equal..
        result.append(input[i] + ",");
      }

    }

    if (input[i] < 99) {
      result.append((input[i] + 1) + "-100)");
    } else if (input[i] == 99) {
      result.append("100)");
    } else if (input[i] == 100) {
      result.replace(result.length()-1, result.length(), ")");
    }
    return result.toString();
  }
  
  public static void main(String[] args) {
    int[] input1 = {50, 75, 80, 97, 99};
    System.out.println(getRangeArray(input1));
    int[] input2 = {1, 2, 4, 75, 80, 97, 99, 100};
    System.out.println(getRangeArray(input2));
  }
}