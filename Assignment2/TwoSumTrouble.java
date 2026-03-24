public class TwoSumTrouble {
    public static void main(String[] args) throws Exception {
        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        int N = Integer.parseInt(els1[0]);
        long S = Integer.parseInt(els1[1]);

        String input2 = FastIO.readString();
        String[] els2 = input2.split(" ");
        long[] arr = new long[N];
        for (int j = 0; j < els2.length; j++) {
            arr[j] = Integer.parseInt(els2[j]);
        }
        int[] res = { 0, 0 };
        int i = 0, j = arr.length - 1;
        boolean found = false;
        while (i < j) {
            long sum = arr[i] + arr[j];
            if (sum == S) {
                res[0] = i + 1;
                res[1] = j + 1;
                found = true;
                break;
            }

            if (sum > S) {
                j--;
            } else if (sum < S) {
                i++;
            }

        }

        if (found) {
            FastIO.writeLn(res[0] + " " + res[1]);
        } else {
            FastIO.writeLn(-1);
        }
        FastIO.close();
    }
}
