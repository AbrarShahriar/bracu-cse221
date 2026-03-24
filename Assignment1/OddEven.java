public class OddEven {
    public static void main(String[] args) throws Exception {

        int numOfInputs = FastIO.readInt();

        for (int i = 0; i < numOfInputs; i++) {
            int num = FastIO.readInt();
            if (num % 2 == 0) {
                FastIO.writeLn(num + " is an Even number.");
            } else {
                FastIO.writeLn(num + " is an Odd number.");
            }
        }
        FastIO.close();
    }
}
