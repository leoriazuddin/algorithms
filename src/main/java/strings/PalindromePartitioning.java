package strings;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given string print all possible palindrome partitions.
 * Palindrome partition: Every partition is palindrome and all partitions together form the input.
 *
 * aab -> {a, a, b}, {aa, b}
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        allPalPartitions("aab");
    }

    private static void allPalPartitions(String input) {
        int n = input.length();

        // To Store all palindromic partitions
        List<List<String>> allPart = new ArrayList<>();

        // To store current palindromic partition
        Deque<String> currPart = new LinkedList<>();

        // Call recursive function to generate
        // all partiions and store in allPart
        allPalPartitons(allPart, currPart, 0, n, input);

        // Print all partitions generated by above call
        print(allPart);

    }

    private static void print(List<List<String>> allPart) {
        for (int i = 0; i < allPart.size(); i++) {
            for (int j = 0; j < allPart.get(i).size(); j++) {
                System.out.print("\t" + allPart.get(i).get(j) + " ");
            }
        }
    }

    private static void allPalPartitons(List<List<String>> allPart,
                                        Deque<String> currPart, int start, int n, String input) {
        // If 'start' has reached len
        if (start >= n) {
            allPart.add(new ArrayList<>(currPart));
            return;
        }

        // Pick all possible ending points for substrings
        for (int i = start; i < n; i++) {

            // If substring str[start..i] is palindrome
            if (isPalindrome(input, start, i)) {

                // Add the substring to result
                String s = input.substring(start, i + 1);
                currPart.addLast(s);

                // Recur for remaining remaining substring
                allPalPartitons(allPart, currPart, i + 1, n, input);

                // Remove substring str[start..i] from current partition
                currPart.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String input,
                                        int start, int i) {
        while (start < i) {
            if (input.charAt(start++) != input.charAt(i--))
                return false;
        }
        return true;
    }
}
