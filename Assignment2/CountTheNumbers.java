public class CountTheNumbers {
    public static void main(String[] args) throws Exception {
        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        int n = Integer.parseInt(els1[0]);
        int q = Integer.parseInt(els1[1]);

        String input2 = FastIO.readString();
        String[] els2 = input2.split(" ");
        long[] arr = new long[n];
        for (int j = 0; j < els2.length; j++) {
            arr[j] = Long.parseLong(els2[j]);
        }

        for (int i = 0; i < q; i++) {
            String input3 = FastIO.readString();
            String[] els3 = input3.split(" ");
            long low = Long.parseLong(els3[0]);
            long high = Long.parseLong(els3[1]);

            if (low > arr[arr.length - 1]) {
                FastIO.writeLn(0);
                continue;
            } else if (high < arr[0]) {
                FastIO.writeLn(0);
                continue;
            }

            int l = 0, r = arr.length - 1;
            int leftMostIdx = -1, rightMostIdx = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (low <= arr[mid] && arr[mid] <= high) {
                    leftMostIdx = mid;
                    r = mid - 1;
                } else if (arr[mid] < low) {
                    l = mid + 1;
                } else if (arr[mid] > high) {
                    r = mid - 1;
                }
            }
            l = 0;
            r = arr.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (low <= arr[mid] && arr[mid] <= high) {
                    rightMostIdx = mid;
                    l = mid + 1;
                } else if (arr[mid] < low) {
                    l = mid + 1;
                } else if (arr[mid] > high) {
                    r = mid - 1;
                }
            }

            if (leftMostIdx == -1 || rightMostIdx == -1) {
                FastIO.writeLn(0);
            } else {
                FastIO.writeLn(rightMostIdx - leftMostIdx + 1);
            }

        }
        FastIO.close();
    }
}
