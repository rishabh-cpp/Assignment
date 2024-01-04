public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 10;
        int[] fibonacciSeries = new int[n];

        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
        }

        System.out.println("First " + n + " numbers of Fibonacci series:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciSeries[i] + " ");
        }
    }
}