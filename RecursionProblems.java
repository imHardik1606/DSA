public class RecursionProblems {
    public static int tilingProblem(int n) {// 2xn (floor size)
        if (n == 0 || n == 1) {
            return 1;
        }
        // kaam
        // Vertical Choice
        int fnm1 = tilingProblem(n - 1);

        // Horizontal choice
        int fnm2 = tilingProblem(n - 2);

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        // kaam
        char currCh = str.charAt(idx);

        if (map[currCh - 'a'] == true) {
            // duplicate
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currCh - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currCh), map);
        }
    }

    public static int friendsPair(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // choice
        // single
        // int fnm1 = friendsPair(n-1);

        // pair
        // int fnm2 = friendsPair(n-2);
        // int pairWays = (n-1) * fnm2;

        // //totalWays
        // int totalWays = fnm1+pairWays;
        // return totalWays;

        return friendsPair(n - 1) + ((n - 1) * friendsPair(n - 2));
    }

    public static void printBinString(int n, int lastPlace, String str) {
        //Base case
        if(n==0){
            System.out.println(str);
            return;
        }
        // kaam
        // if(lastPlace == 0){
        // //sit 0 on chair n
        // printBinString(n-1, 0, str.append("0"));
        // printBinString(n-1, 1, str.append("1"));
        // } else{
        // printBinString(n-1, 0, str.append("1"));
        // }

        printBinString(n - 1, 0, str+"0");
        
        if (lastPlace == 0) {
            printBinString(n - 1, 1, str+"1");
        }
    }

    public static void main(String[] args) {
       printBinString(3, 0, "");
    }
}
