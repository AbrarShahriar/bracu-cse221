import java.util.ArrayList;
import java.util.Arrays;

public class H {
    public static void main(String[] args) throws Exception {
        int[] NQ = FastIO.readInts(2);

        int N = NQ[0], Q = NQ[1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(N + 1);
        graph.add(null);

        for (int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
            for (int j = 1; j <= N; j++) {
                if (i != j && gcd(i, j) == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        for (int q = 0; q < Q; q++) {
            int[] XK = FastIO.readInts(2);
            int X = XK[0], K = XK[1];

            ArrayList<Integer> xthNode = graph.get(X);
            if (xthNode.size() < K) {
                FastIO.writeLn(-1);
            } else {
                FastIO.writeLn(xthNode.get(K - 1));
            }
        }

        FastIO.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
