
public class FastSeriesDrift {

    public static long[] calcSum(long a, long n, long m) {
        if (n == 0)
            return new long[] { 0, 1 % m };

        if (n == 1)
            return new long[] { a % m, a % m };

        long[] half = calcSum(a, n / 2, m);

        long halfSum = half[0];
        long halfPower = half[1];

        long powerN2 = (halfPower * halfPower) % m;
        long sum;

        if (n % 2 == 0) {
            sum = (halfSum * ((1 + halfPower) % m)) % m;
        } else {
            long remainingExtra = (powerN2 * a) % m;
            sum = (halfSum * ((1 + halfPower) % m) + remainingExtra) % m;
        }

        return new long[] { sum, powerN2 };
    }

    public static void main(String[] args) throws Exception {
        int T = FastIO.readInt();

        for (int t = 0; t < T; t++) {
            String[] input = FastIO.readString().split(" ");
            long a = Long.parseLong(input[0]);
            long n = Long.parseLong(input[1]);
            long m = Long.parseLong(input[2]);

            long aModM = a % m;

            // if (aModM == 0) {
            // FastIO.writeLn(0);
            // continue;
            // }

            // if (n == 0) {
            // FastIO.writeLn(0);
            // continue;
            // }

            long[] result = calcSum(aModM, n, m);
            FastIO.writeLn(result[0]);
        }

        FastIO.close();
    }
}