public class ClimbingStairs {
    public static int countways(int n) { // recursion
        if (n == 0) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        return countways(n - 1) + countways(n - 2);
    }

    public static int memoization(int n, int dp[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);

        return dp[n];
    }

    public static int Tablulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        //tabulation loop
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; // n = 3 -> 3 & n = 4 -> 5
        // int dp[] = new int[n + 1];
        // System.out.println(countways(n));
        // Arrays.fill(dp, -1);
        // System.out.println(memoization(n, dp));
        System.out.println(Tablulation(n));
    }
}
