import java.util.Scanner;

public class StringPermutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("Input: " + input);
        System.out.println("Output:");
        printPermutations(input);
    }

    public static void printPermutations(String input) {
        printPermutationsHelper(input.toCharArray(), 0, input.length() - 1);
    }

    private static void printPermutationsHelper(char[] charArray, int start, int end) {
        if (start == end) {
            System.out.println(new String(charArray));
        } else {
            for (int i = start; i <= end; i++) {
                swap(charArray, start, i);
                printPermutationsHelper(charArray, start + 1, end);
                swap(charArray, start, i);
            }
        }
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
