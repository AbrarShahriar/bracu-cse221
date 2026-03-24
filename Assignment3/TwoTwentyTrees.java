public class TwoTwentyTrees {
    static int[] inorder;
    static int[] preorder;
    static int preIndex = 0;

    public static void main(String[] args) throws Exception {
        int n = FastIO.readInt();

        inorder = new int[n];
        preorder = new int[n];

        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        inorder = new int[n];
        for (int j = 0; j < els1.length; j++) {
            inorder[j] = Integer.parseInt(els1[j]);
        }

        String input2 = FastIO.readString();
        String[] els2 = input2.split(" ");
        preorder = new int[n];
        for (int j = 0; j < els2.length; j++) {
            preorder[j] = Integer.parseInt(els2[j]);
        }

        buildPostOrder(0, n - 1);
        FastIO.close();
    }

    static void buildPostOrder(int left, int right) throws Exception {
        if (left > right)
            return;

        int root = preorder[preIndex++];
        int mid = left;
        while (inorder[mid] != root) {
            mid++;
        }

        buildPostOrder(left, mid - 1);
        buildPostOrder(mid + 1, right);

        FastIO.write(root + " ");
    }
}
