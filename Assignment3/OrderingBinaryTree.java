public class OrderingBinaryTree {
    public static int idx = 0;

    public static void main(String[] args) throws Exception {
        int N = FastIO.readInt();
        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        long[] arr = new long[N];
        for (int j = 0; j < els1.length; j++) {
            arr[j] = Long.parseLong(els1[j]);
        }
        long[] seq = new long[N];
        buildTree(arr, 0, arr.length - 1, seq);

        for (int i = 0; i < seq.length; i++) {
            FastIO.write(seq[i] + " ");
        }
        FastIO.close();
    }

    public static void buildTree(long[] arr, int start, int end, long[] seq) {
        if (start > end)
            return;

        int mid = (start + end) / 2;
        seq[idx] = arr[mid];
        idx++;
        buildTree(arr, start, mid - 1, seq);
        buildTree(arr, mid + 1, end, seq);
    }
}
