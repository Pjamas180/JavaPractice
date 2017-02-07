import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        HashMap<Character, Integer> firstMap = new HashMap<>();
        HashMap<Character, Integer> secondMap = new HashMap<>();
        if (first != null) {
            firstMap = getEachLetterCount(first);
        }
        if (second != null) {
            secondMap = getEachLetterCount(second);
        }
        return getNumberToRemove(firstMap, secondMap);
    }
    
    public static HashMap<Character, Integer> getEachLetterCount(String word) {
        HashMap<Character, Integer> mapForLetterCount = new HashMap<>();
        for (char i = 'a'; i < 'z'; i++) {
            mapForLetterCount.put(i,0);
        }
        for (int i = 0; i < word.length(); i++) {
            int num = mapForLetterCount.get(word.charAt(i));
            num++;
            mapForLetterCount.put(word.charAt(i), num);
        }
        return mapForLetterCount;
    }
    
    public static int getNumberToRemove(HashMap<Character, Integer> firstMap, HashMap<Character, Integer> secondMap) {
        int numToRemove = 0;
        for (char i = 'a'; i < 'z'; i++) {
            if (firstMap.get(i) < secondMap.get(i)) {
                numToRemove += secondMap.get(i) - firstMap.get(i);
            } else if (firstMap.get(i) > secondMap.get(i)) {
                numToRemove += firstMap.get(i) - secondMap.get(i);
            }
        }
        return numToRemove;
    }
    
    public static int numberNeeded2(String first, String second) {
        int[] freq = new int[26];
        for (int i = 0; i < first.length(); i++) {
            char letter = first.charAt(i);
            freq['z'-letter]++;
        }
        for (int i = 0; i < second.length(); i++) {
            char letter = second.charAt(i);
            freq['z'-letter]--;
        }
        int numToRemove = 0;
        for (int i = 0; i < freq.length; i++) {
            numToRemove += Math.abs(freq[i]);
        }
        return numToRemove;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded2(a, b));
    }
}