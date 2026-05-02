
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class E {
    public static void main(String[] args) throws Exception {
        int[] NMSQ = FastIO.readInts(4);
        int N = NMSQ[0], M = NMSQ[1], S = NMSQ[2], Q = NMSQ[3];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int m = 0; m < M; m++) {
            int[] uv = FastIO.readInts(2);
            int u = uv[0], v = uv[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        int[] sources = FastIO.readInts(S);
        int[] destinations = FastIO.readInts(Q);

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        BFS(list, dist, sources);

        for (int destination : destinations) {
            FastIO.write(dist[destination] + " ");
        }
        FastIO.close();

    }

    public static void BFS(ArrayList<ArrayList<Integer>> list, int[] dist, int[] sources) {
        Queue<Integer> queue = new ArrayDeque<Integer>();

        for (int s : sources) {
            queue.add(s);
            dist[s] = 0;
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : list.get(u)) {
                if (dist[v] == -1) {
                    queue.add(v);
                    dist[v] = dist[u] + 1;
                }
            }
        }
    }
}