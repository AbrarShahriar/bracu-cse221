import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class E {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
    public static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        int[] NMQ = readInts(3);
        int N = NMQ[0], M = NMQ[1], Q = NMQ[2];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] uv = readInts(2);
            int u = uv[0], v = uv[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        int id = 1;
        int[] componentId = new int[N + 1];
        Arrays.fill(componentId, -1);

        for (int u = 1; u <= N; u++) {
            if (componentId[u] == -1) {
                BFS(list, u, componentId, id);
                id++;
            }
        }

        for (int i = 0; i < Q; i++) {
            int[] xy = readInts(2);
            int x = xy[0], y = xy[1];

            if (componentId[x] != componentId[y]) {
                pw.println("NO");
                continue;
            }

            pw.println("YES");
        }

        pw.flush();
    }

    public static void BFS(ArrayList<ArrayList<Integer>> list, int source, int[] componentId, int id) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(source);
        componentId[source] = id;

        while (!queue.isEmpty()) {
            int u = queue.remove();
            ArrayList<Integer> neighbours = list.get(u);
            for (int i = 0; i < neighbours.size(); i++) {
                int v = neighbours.get(i);
                if (componentId[v] == -1) {
                    componentId[v] = id;
                    queue.add(v);
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
}
