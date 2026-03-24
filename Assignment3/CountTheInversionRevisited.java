public class CountTheInversionRevisited {

    public static void main(String[] args) throws Exception {
        int N = FastIO.readInt();

        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        int[] arr = new int[N];
        for (int j = 0; j < els1.length; j++) {
            arr[j] = Math.abs(Integer.parseInt(els1[j]));
        }

        long invCount = mergeSort(arr, 0, arr.length - 1);

        FastIO.writeLn(invCount);
        FastIO.close();
    }

    public static long mergeSort(int[] nums, int start, int end) throws Exception {
        if (start < end) {
            int mid = (start + end) / 2;
            long leftInvCount = mergeSort(nums, start, mid);
            long rightInvCount = mergeSort(nums, mid + 1, end);
            return leftInvCount + rightInvCount + merge(nums, start, mid, end);
        }
        return 0;
    }

    public static long merge(int[] arr, int start, int mid, int end) throws Exception {
        int i = start, j = mid + 1, idx = 0;
        long invCount = 0;
        int[] temp = new int[end - start + 1];

        while (i <= mid && j <= end) {
            long square = ((long) arr[j] * (long) arr[j]);
            if ((long) arr[i] > square) {
                invCount += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        i = start;
        j = mid + 1;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[idx] = arr[i];
                i++;
                idx++;
            } else {
                temp[idx] = arr[j];
                j++;
                idx++;
            }
        }

        while (i <= mid) {
            temp[idx] = arr[i];
            i++;
            idx++;
        }

        while (j <= end) {
            temp[idx] = arr[j];
            j++;
            idx++;
        }

        for (int x = 0; x < temp.length; x++) {
            arr[x + start] = temp[x];
        }

        return invCount;
    }
}