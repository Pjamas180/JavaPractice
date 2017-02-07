import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    
    public double findRunningMedian(int newNumber) {
        
        // Only when starting off
        if (minHeap.size() < maxHeap.size()) {
            minHeap.add(newNumber);
        } else {
            maxHeap.add(newNumber);
        }

        // Balance the trees
        if (minHeap.size() != 0) {
            if (maxHeap.peek() > minHeap.peek()) {
                int temp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(temp);
            }
        }
        
        // Find the correct value based on if it's even or odd.
        if (maxHeap.size() == minHeap.size()) { // if even
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        } else { // if odd
            return (maxHeap.size() > minHeap.size()) ? (double)maxHeap.peek() : (double)minHeap.peek();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            System.out.println(solution.findRunningMedian(a[a_i]));
        }
    }
}