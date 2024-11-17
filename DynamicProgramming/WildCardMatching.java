public class WildCardMatching {
    public static boolean wildcardMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        // initialisation
        dp[0][0] = true;
        // pattern = " "
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        // text = " "
        for (int j = 1; j < m + 1; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // bottom up

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //case 1 -> ith char == jth char || jth char == ?
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String text = "abc";
        String pattern = "**d";
        System.out.println(wildcardMatching(text, pattern));
    }
}
