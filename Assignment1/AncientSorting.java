public class AncientSorting {
    public static void main(String[] args) throws Exception {
        int N = FastIO.readInt();

        long[] arr = new long[N];
        String str = FastIO.readString();
        String[] els = str.split(" ");

        for (int j = 0; j < els.length; j++) {
            arr[j] = Integer.parseInt(els[j]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (((arr[j] % 2 == 0 && arr[j + 1] % 2 == 0)
                        || (arr[j] % 2 != 0 && arr[j + 1] % 2 != 0)) && arr[j] > arr[j + 1]) {
                    long temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int k = 0; k < arr.length; k++) {
            FastIO.write(arr[k] + " ");
        }

        FastIO.close();
    }
}
