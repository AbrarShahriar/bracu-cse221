public class FastSum {
    public static void main(String[] args) throws Exception {
        int numOfTests = FastIO.readInt();
        for (int i = 0; i < numOfTests; i++) {
            long n = FastIO.readInt();
            long sum = (n * (n + 1)) / 2;
            FastIO.writeLn(sum);
        }
        FastIO.close();
    }
}
