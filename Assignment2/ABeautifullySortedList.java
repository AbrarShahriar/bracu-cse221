
public class ABeautifullySortedList {
    public static void main(String[] args) throws Exception {
        int N = FastIO.readInt();
        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        int[] arr1 = new int[N];
        for (int i = 0; i < els1.length; i++) {
            arr1[i] = Integer.parseInt(els1[i]);
        }

        int M = FastIO.readInt();
        String input2 = FastIO.readString();
        String[] els2 = input2.split(" ");
        int[] arr2 = new int[M];
        for (int i = 0; i < els2.length; i++) {
            arr2[i] = Integer.parseInt(els2[i]);
        }

        int i = 0, j = 0;
        int[] mergedArr = new int[N + M];

        boolean arr1Ended = false, arr2Ended = false;

        for (int k = 0; k < mergedArr.length; k++) {
            if (arr1Ended) {
                mergedArr[k] = arr2[j];
                j++;
                continue;
            }
            if (arr2Ended) {
                mergedArr[k] = arr1[i];
                i++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                mergedArr[k] = arr1[i];
                i++;
                if (i == arr1.length)
                    arr1Ended = true;
            } else {
                mergedArr[k] = arr2[j];
                j++;
                if (j == arr2.length)
                    arr2Ended = true;
            }
        }

        for (int c = 0; c < mergedArr.length; c++) {
            FastIO.write(mergedArr[c] + " ");
        }

        FastIO.close();
    }
}
