import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithoutDuplicates {

    public static String findLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        s = s.toLowerCase();
        int n = s.length();
        int start = 0, end = 0;
        int maxLength = 0;
        int maxStart = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        while (end < n) {
            char currentChar = s.charAt(end);

            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(charIndexMap.get(currentChar) + 1, start);
            }

            charIndexMap.put(currentChar, end);

            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }

            end++;
        }

        if (maxStart + maxLength <= n) {
            return s.substring(maxStart, maxStart + maxLength);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String longestSubstring = findLongestSubstring(input);

        System.out.println("Input String: " + input);
        System.out.println("Longest Substring Without Duplicates: " + longestSubstring);
    }
}
