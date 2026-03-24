
import java.util.ArrayList;
import java.util.List;

public class TwoTwentyTreesReassessed {
    public static List<Integer> buildPreOrder(int[] inorder, int[] postorder,
            int inStart, int inEnd,
            int postStart, int postEnd) {
        List<Integer> result = new ArrayList<>();

        if (inStart > inEnd || postStart > postEnd) {
            return result;
        }

        int rootVal = postorder[postEnd];
        result.add(rootVal);

        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;

        List<Integer> leftPre = buildPreOrder(inorder, postorder,
                inStart, rootIndex - 1,
                postStart, postStart + leftSize - 1);

        List<Integer> rightPre = buildPreOrder(inorder, postorder,
                rootIndex + 1, inEnd,
                postStart + leftSize, postEnd - 1);

        result.addAll(leftPre);
        result.addAll(rightPre);

        return result;
    }

    public static void main(String[] args) throws Exception {

        int N = FastIO.readInt();

        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        int[] inorder = new int[N];
        for (int j = 0; j < els1.length; j++) {
            inorder[j] = Integer.parseInt(els1[j]);
        }

        String input2 = FastIO.readString();
        String[] els2 = input2.split(" ");
        int[] postorder = new int[N];
        for (int j = 0; j < els2.length; j++) {
            postorder[j] = Integer.parseInt(els2[j]);
        }

        List<Integer> preorder = buildPreOrder(inorder, postorder, 0, N - 1, 0, N - 1);

        for (int i = 0; i < preorder.size(); i++) {
            if (i > 0) {
                FastIO.write(" ");
            }
            FastIO.write(preorder.get(i));
        }
        FastIO.writeLn("");

        FastIO.close();
    }
}
