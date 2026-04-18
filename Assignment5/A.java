import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
    public static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        int[] NM = readInts(2);

        int N = NM[0], M = NM[1];

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        int[] visited = new int[list.length];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int[] uv = readInts(2);
            int u = uv[0], v = uv[1];
            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] != 1)
                BFS(list, visited, i);
        }

        pw.flush();
    }

    public static void BFS(ArrayList<Integer>[] list, int[] visited, int sourceNode) {
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[sourceNode] = 1;
        queue.add(sourceNode);

        while (!queue.isEmpty()) {
            int u = queue.remove();
            pw.write(u + " ");
            for (int v : list[u]) {
                if (visited[v] != 1) {
                    visited[v] = 1;
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

    public static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
