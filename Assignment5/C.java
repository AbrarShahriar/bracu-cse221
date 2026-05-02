import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
    public static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        int[] NMSD = readInts(4);
        int N = NMSD[0], M = NMSD[1], S = NMSD[2], D = NMSD[3];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        int[] us = readInts(M);
        int[] vs = readInts(M);

        for (int i = 0; i < M; i++) {
            list.get(us[i]).add(vs[i]);
            list.get(vs[i]).add(us[i]);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(list.get(i));

        int[] visited = new int[N + 1];
        int[] distance = new int[N + 1];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }

        BFS(list, visited, distance, S, D);

        pw.flush();

    }

    public static void BFS(ArrayList<ArrayList<Integer>> list, int[] visited, int[] distance, int source,
            int destination) {
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[destination] = 1;
        distance[destination] = 0;
        queue.add(destination);

        while (!queue.isEmpty()) {
            int u = queue.remove();

            ArrayList<Integer> neighbours = list.get(u);
            for (int i = 0; i < neighbours.size(); i++) {
                int v = neighbours.get(i);

                if (distance[v] == -1) {
                    visited[v] = 1;
                    distance[v] = distance[u] + 1;
                    queue.add(v);
                }
            }
        }

        if (distance[source] == -1) {
            pw.write("-1");
            return;
        }

        pw.println(distance[source]);
        StringBuilder sb = new StringBuilder();
        int cur = source;
        while (cur != destination) {
            sb.append(cur).append(' ');
            for (int v : list.get(cur)) {
                if (distance[v] == distance[cur] - 1) {
                    cur = v;
                    break;
                }
            }
        }
        sb.append(destination);
        pw.println(sb);
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
