class MCM {
    public static int mcmRec(int arr[], int i, int j) {
        if (i == j) {
            return 0; // single matrix case
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmRec(arr, i, k);// Ai....Ak => arr[i-1] x arr[k]
            int cost2 = mcmRec(arr, k + 1, j);// Ak+1....Aj => arr[k] x arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        return ans;
    }

    public static int mcmMemo(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmMemo(arr, i, k, dp);
            int cost2 = mcmMemo(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];

            ans = Math.min(ans, cost1+cost2+cost3);
        }

        return dp[i][j] = ans;

    }

    public static int mcmTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        // initialisation
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;

        }

        // bottom-up
        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1; // col

                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);

                }
            }
        }
        print(dp);
        return dp[1][n - 1];
    }
    
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        //int n = arr.length;

        // int dp[][] = new int[n][n];

        // for (int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

       System.out.println(mcmTab(arr));
    }
}