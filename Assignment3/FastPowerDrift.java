public class FastPowerDrift {
    public static void main(String[] args) throws Exception {
        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        int a = Integer.parseInt(els1[0]);
        long b = Long.parseLong(els1[1]);
        int m = 107;

        long result = 1;
        a = a % m;

        while (b > 0) {
            if ((b % 2) != 0) {
                result = (result * a) % m;
            }
            a = (int) Math.pow(a, 2) % m;
            b = b / 2;
        }

        FastIO.writeLn(result);
        FastIO.close();
    }
}
