package week01;

import java.util.*;

public class Day1 {

    // TODO 1: Return the largest value. Target: O(n) time, O(1) space.
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // TODO 2: Reverse the array in place using two pointers
    // (one at the start, one at the end, swap, move inward).
    // Target: O(n) time, O(1) space. No new array allowed.
    static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Brute force, given to you: compare every pair. O(n²) time, O(1) space.
    static boolean hasDuplicateBrute(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j]) return true;
        return false;
    }

    // TODO 3: Same problem using a HashSet.
    // Target: O(n) time, O(n) space. Notice the trade: memory for speed.
    static boolean hasDuplicateFast(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] small = {3, 9, 1, 7};
        System.out.println("max = " + findMax(small));          // expect 9
        reverse(small);
        System.out.println(Arrays.toString(small));             // expect [7, 1, 9, 3]

        // Timing: unique values, so both methods must scan everything (worst case)
        for (int n : new int[]{10_000, 20_000, 40_000, 80_000}) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) data[i] = i;

            long t1 = System.nanoTime();
            hasDuplicateBrute(data);
            long brute = (System.nanoTime() - t1) / 1_000_000;

            long t2 = System.nanoTime();
            hasDuplicateFast(data);
            long fast = (System.nanoTime() - t2) / 1_000_000;

            System.out.printf("n=%,d  brute=%d ms  fast=%d ms%n", n, brute, fast);
        }
    }
}