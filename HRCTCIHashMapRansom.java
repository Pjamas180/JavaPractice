import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static String canCreateRansom(String[] mag, String[] ransom) {
        HashMap<String, Integer> magMap = new HashMap<>();
        for (int i = 0; i < mag.length; i++) {
            if (!magMap.containsKey(mag[i])) {
                magMap.put(mag[i], 1);
            } else {
                int value = magMap.get(mag[i]);
                value++;
                magMap.put(mag[i], value);
            }
        }
        for (int i = 0; i < ransom.length; i++) {
            if (!magMap.containsKey(ransom[i]) || magMap.get(ransom[i]) < 1) {
                return "No";
            } else {
                int value = magMap.get(ransom[i]);
                value--;
                magMap.put(ransom[i], value);
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        System.out.println(canCreateRansom(magazine, ransom));
    }
}
