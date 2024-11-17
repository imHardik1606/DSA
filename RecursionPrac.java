public class RecursionPrac {
    public static void keyIndices(int arr[], int key, int idx) {
        if (idx == arr.length) {
            return;
        }
        // kaam
        if (arr[idx] == key) {
            System.out.print(idx + " ");
        }

        keyIndices(arr, key, idx + 1);
    }

    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void printDigits(int number){
        if(number==0){
            return;
        }
        //kaam
        int lastDigit = number%10;

        printDigits(number/10);

        System.out.print(digits[lastDigit]+" ");
    }

    public static int stringLength(String str){
        if(str.length()==0){
            return 0;
        }
        //kaam
        return stringLength(str.substring(1)) +1;
    }

    public static int countStr(String str, int i, int j, int n){
        if(n==1){
            return 1;
        }
        if(n<=0){
            return 0;
        }
        //kaam
        int res = countStr(str, i+1, j, n-1) + countStr(str, i, j-1, n-1) - countStr(str, i+1, j-1, n-2);

        if(str.charAt(i)==str.charAt(j)){
            res++;
        }

        return res;
    }
    public static void main(String[] args) {
        String str = "abcd";
        int n = str.length();
        System.out.println(countStr(str, 0, n-1, n));
    }
}
