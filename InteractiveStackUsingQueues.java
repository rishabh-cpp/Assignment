import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InteractiveStackUsingQueues {

    private Queue<Integer> primaryQueue;
    private Queue<Integer> auxiliaryQueue;

    public InteractiveStackUsingQueues() {
        primaryQueue = new LinkedList<>();
        auxiliaryQueue = new LinkedList<>();
    }

    public void push(int value) {
        while (!primaryQueue.isEmpty()) {
            auxiliaryQueue.add(primaryQueue.poll());
        }

        primaryQueue.add(value);

        while (!auxiliaryQueue.isEmpty()) {
            primaryQueue.add(auxiliaryQueue.poll());
        }
    }

    public int pop() {
        if (primaryQueue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return primaryQueue.poll();
    }

    public int top() {
        if (primaryQueue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return primaryQueue.peek();
    }

    public boolean isEmpty() {
        return primaryQueue.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InteractiveStackUsingQueues stack = new InteractiveStackUsingQueues();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    int pushValue = scanner.nextInt();
                    stack.push(pushValue);
                    System.out.println("Element " + pushValue + " pushed onto the stack.");
                    break;
                case 2:
                    try {
                        int poppedValue = stack.pop();
                        System.out.println("Popped element: " + poppedValue);
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        int topValue = stack.top();
                        System.out.println("Top element: " + topValue);
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
