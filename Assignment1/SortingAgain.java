
public class SortingAgain {
    public static void main(String[] args) throws Exception {
        int T = FastIO.readInt();
        while (T-- > 0) {
            int n = FastIO.readInt();

            int[] a = new int[n]; // IDs
            int[] b = new int[n]; // Marks

            String str1 = FastIO.readString();
            String[] els1 = str1.split(" ");
            for (int j = 0; j < els1.length; j++) {
                a[j] = Integer.parseInt(els1[j]);
            }

            String str2 = FastIO.readString();
            String[] els2 = str2.split(" ");
            for (int j = 0; j < els2.length; j++) {
                b[j] = Integer.parseInt(els2[j]);
            }

            // Create 2D array to store pairs
            int[][] ab = new int[n][2];
            for (int i = 0; i < n; i++) {
                ab[i][0] = a[i]; // ID
                ab[i][1] = b[i]; // Mark
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                int maxIndex = i;

                for (int j = i + 1; j < n; j++) {
                    if (ab[j][1] > ab[maxIndex][1] ||
                            (ab[j][1] == ab[maxIndex][1] && ab[j][0] < ab[maxIndex][0])) {
                        maxIndex = j;
                    }
                }

                if (maxIndex != i) {
                    // Swap rows
                    int tempId = ab[i][0];
                    int tempMark = ab[i][1];

                    ab[i][0] = ab[maxIndex][0];
                    ab[i][1] = ab[maxIndex][1];

                    ab[maxIndex][0] = tempId;
                    ab[maxIndex][1] = tempMark;

                    count++;
                }
            }

            FastIO.writeLn("Minimum swaps: " + count);
            for (int i = 0; i < n; i++) {
                FastIO.writeLn("ID: " + ab[i][0] + " Mark: " + ab[i][1]);
            }
        }

        FastIO.close();
    }
}
