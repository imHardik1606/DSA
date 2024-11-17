public class Recursion {
    public static void decreasingOrder(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        System.out.print(n + " ");
        decreasingOrder(n - 1);
    }

    public static void printIncr(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printIncr(n - 1);
        System.out.print(n + " ");
    }

    public static int printFact(int n) {
        // Space Complecity = O(n)
        if (n == 0) {
            return 1;
        }

        return n * printFact(n - 1);
    }

    public static int calcSum(int n) {
        if (n == 1) {
            return 1;
        }

        return n + calcSum(n - 1);
    }

    public static int fibonacci(int n) {
        // Space Complexity = O (n)
        // Time Complexity = O (n^2)
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static boolean isSorted(int arr[], int i) {
        // Time Complexity = O (n)
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int arr[], int i, int key) {
         // Space Complexity = O (n)
        // Time Complexity = O (n)
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }

        return firstOccurence(arr, i + 1, key);
    }

    public static void main(String[] args) {
        int arr[] = { 8, 3, 6, 9, 5, 10, 2, 5, 3 };
        System.out.println(firstOccurence(arr, 0, 5+5));
    }
}