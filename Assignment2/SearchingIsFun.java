public class SearchingIsFun {
    public static void main(String[] args) throws Exception {
        int T = FastIO.readInt();

        for (int t = 0; t < T; t++) {
            String input1 = FastIO.readString();
            String[] els1 = input1.split(" ");
            long k = Integer.parseInt(els1[0]);
            long x = Integer.parseInt(els1[1]);

            long res = k + ((k - 1) / (x - 1));

            FastIO.writeLn(res);
        }
        FastIO.close();
    }
}
