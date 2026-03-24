public class TwoSumRevisited {
    public static void main(String[] args) throws Exception {
        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        int N = Integer.parseInt(els1[0]);
        int M = Integer.parseInt(els1[1]);
        long K = Integer.parseInt(els1[2]);

        String input2 = FastIO.readString();
        String[] els2 = input2.split(" ");
        long[] A = new long[N];
        for (int j = 0; j < els2.length; j++) {
            A[j] = Integer.parseInt(els2[j]);
        }

        String input3 = FastIO.readString();
        String[] els3 = input3.split(" ");
        long[] B = new long[M];
        for (int j = 0; j < els3.length; j++) {
            B[j] = Integer.parseInt(els3[j]);
        }

        int[] res = { 0, 0 };
        int i = 0, j = B.length - 1;

        long min = Integer.MAX_VALUE;
        while ((0 <= i && i < A.length) || (B.length - 1 >= j && j > 0)) {
            long sum = A[i] + B[j];
            long dist = Math.abs(sum - K);

            if (dist <= min) {
                min = dist;
                res[0] = i + 1;
                res[1] = j + 1;
            }
            if (sum == K) {
                min = dist;
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            } else if (sum > K) {
                j--;
                if (j < 0)
                    break;
            } else if (sum < K) {
                i++;
                if (i > A.length - 1)
                    break;
            }

        }

        FastIO.writeLn(res[0] + " " + res[1]);
        FastIO.close();
    }
}
