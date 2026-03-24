
import java.util.Arrays;

public class ReverseSorting {
    public static void main(String[] args) throws Exception {
        int N = FastIO.readInt();
        int[] arr = new int[N];
        String str = FastIO.readString();
        String[] els = str.split(" ");
        for (int j = 0; j < els.length; j++) {
            arr[j] = Integer.parseInt(els[j]);
        }

        int[][] pairs = new int[arr.length][2];
        int M = 0;

        // Odd
        int[] odd = new int[]

        // Even

        // Interleave

        // Compare



        // boolean done = false;
        // while (!done) {
        //     done = true;
        //     for (int i = 0; i < arr.length - 2; i++) {
        //         if (arr[i] > arr[i + 2]) {
        //             done = false;
        //             int temp = arr[i];
        //             arr[i] = arr[i + 2];
        //             arr[i + 2] = temp;

        //             pairs[M][0] = i;
        //             pairs[M][1] = i + 2;
        //             M++;
        //         }
        //     }
        // }

        // if (isSorted(arr)) {
        //     printResult(true, pairs, M);
        // } else {
        //     printResult(false, pairs, M);
        // }
    }

    public static boolean isSorted(int[] arr) {
        boolean sorted = true;
        for (int j = 0; j < arr.length; j++) {
            if (j + 1 < arr.length) {
                if (!(arr[j] <= arr[j + 1])) {
                    sorted = false;
                    break;
                }
            }
        }
        return sorted;
    }

    public static void printResult(boolean isSortable, int[][] pairs, int M) throws Exception {
        if (isSortable) {
            FastIO.writeLn("YES");
            FastIO.writeLn(M);
            for (int i = 0; i < M; i++) {
                FastIO.writeLn((pairs[i][0] + 1) + " " + (pairs[i][1] + 1));
            }
        } else {
            FastIO.writeLn("NO");
        }
        FastIO.close();
    }

    public static int[] bubbleSort(int[] arr, int index, int[][] pairs, int M) {
        for (int start = index; start < arr.length; start += 2) {
            for (int i = start; start < arr.length - 2; i += 2) {

                if (arr[i] > arr[i + 2]) {
                    // reverse i..i+2
                    int temp = arr[i];
                    arr[i] = arr[i + 2];
                    arr[i + 2] = temp;

                    // 1-based indices
                    pairs[M][0] = i + 1;
                    pairs[M][1] = i + 3;
                    M++;
                }
            }
        }
        return arr;
    }

}
