import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class F {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
    public static StringTokenizer st = null;

    public static int idx = 0;

    public static void main(String[] args) throws IOException {
        int[] NR = readInts(2);
        int N = NR[0], R = NR[1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N - 1; i++) {
            int[] uv = readInts(2);
            int u = uv[0], v = uv[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        int[] subtreeSize = new int[N + 1];
        int[] order = new int[N + 1];
        int[] parent = new int[N + 1];

        Arrays.fill(subtreeSize, 1);
        Arrays.fill(parent, -1);

        DFS(list, order, parent, subtreeSize, R);

        for (int i = idx - 1; i >= 1; i--) {
            int u = order[i];
            subtreeSize[parent[u]] += subtreeSize[u];
        }

        int Q = readInt();
        for (int i = 0; i < Q; i++) {
            int X = readInt();
            pw.println(subtreeSize[X]);
        }

        pw.flush();
    }

    public static void DFS(ArrayList<ArrayList<Integer>> list, int[] order, int[] parent, int[] subtreeSize, int root) {
        Stack<Integer> stack = new Stack<Integer>();

        parent[root] = 0;
        stack.push(root);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            order[idx] = u;
            idx++;

            ArrayList<Integer> vs = list.get(u);
            for (int v : vs) {
                if (parent[v] == -1) {
                    parent[v] = u;
                    stack.push(v);
                }
            }
        }

    }

    public static int[] readInts(int numOfInput) throws IOException {
        st = new StringTokenizer(br.readLine());
        int[] inputs = new int[numOfInput];
        for (int i = 0; i < numOfInput; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        return inputs;
    }

    public static int readInt() throws NumberFormatException, IOException {
        return Integer.parseInt(br.readLine());
    }
}
