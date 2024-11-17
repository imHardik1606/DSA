public class mergeSort {
    public static void printArr(int arr[]) {
        for (int i = 0; i <= arr.length-1; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void MrgSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }

        // kaaam
        int mid = si + (ei - si) / 2;

        // left
        MrgSort(arr, si, mid);
        // right
        MrgSort(arr, ei + 1, ei);

        // merge
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0;// iterator for temp

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // left remaining part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // right remaining part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        // copy temp to org
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8, 4};
        MrgSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
