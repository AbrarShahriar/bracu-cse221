public class IsSorted {
    public static void main(String[] args) throws Exception {
        int T = FastIO.readInt();
        for (int i = 0; i < T; i++) {
            int len = FastIO.readInt();
            long[] arr = new long[len];

            String str = FastIO.readString();
            String[] els = str.split(" ");
            for (int j = 0; j < els.length; j++) {
                arr[j] = Integer.parseInt(els[j]);
            }

            // Check if sorted
            boolean sorted = true;
            for (int j = 0; j < arr.length; j++) {
                if (j + 1 < arr.length) {
                    if (!(arr[j] <= arr[j + 1])) {
                        sorted = false;
                        break;
                    }
                }
            }

            if (sorted) {
                FastIO.writeLn("YES");
            } else {
                FastIO.writeLn("NO");
            }
        }

        FastIO.close();
    }
}
