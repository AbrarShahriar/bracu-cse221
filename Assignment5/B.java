
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B {
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

        int[] us = readInts(M);
        int[] vs = readInts(M);

        for (int i = 0; i < us.length; i++) {
            list[us[i]].add(vs[i]);
            list[vs[i]].add(us[i]);
        }

        for (int i = 1; i < list.length; i++) {
            list[i].sort((Integer a, Integer b) -> a - b);
        }

        DFS(list, visited, 1);

        pw.flush();
    }

    public static void DFS(ArrayList<Integer>[] list, int[] visited, int u) {
        visited[u] = 1;
        pw.write(u + " ");
        for (int v : list[u]) {
            if (visited[v] != 1) {
                DFS(list, visited, v);
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
