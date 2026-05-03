import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class A {
    public static void main(String[] args) throws Exception {
        int[] NMSD = FastIO.readInts(4);
        int N = NMSD[0], M = NMSD[1], S = NMSD[2], D = NMSD[3];

        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++)
            list.add(new ArrayList<>());

        int[] us = FastIO.readInts(M);
        int[] vs = FastIO.readInts(M);
        int[] ws = FastIO.readInts(M);

        for (int j = 0; j < M; j++)
            list.get(us[j]).add(new Integer[] { vs[j], ws[j] });

        dijkstrasPath(list, S, D);
        FastIO.close();
    }

    public static void dijkstrasPath(ArrayList<ArrayList<Integer[]>> list, int src, int dst) throws Exception {
        int[] parent = new int[list.size()];
        int[] dist = new int[list.size()];
        Arrays.fill(parent, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        parent[src] = -2;
        dist[src] = 0;
        pq.add(new Integer[] { src, 0 });

        while (!pq.isEmpty()) {
            Integer[] curEntry = pq.poll();
            int u = curEntry[0];

            for (Integer[] neighbourEntry : list.get(u)) {
                int v = neighbourEntry[0], dv = neighbourEntry[1];
                if (dist[u] + dv < dist[v]) {
                    dist[v] = dist[u] + dv;
                    parent[v] = u;
                    pq.add(new Integer[] { v, dist[v] });
                }
            }
        }

        if (parent[dst] == -1) {
            FastIO.writeLn("-1");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>(list.size());
        int cur = dst;

        while (cur != -2) {
            path.add(cur);
            cur = parent[cur];
        }

        FastIO.writeLn(dist[dst]);
        for (int i = path.size() - 1; i >= 0; i--) {
            FastIO.write(path.get(i) + " ");
        }
        FastIO.writeLn("");
    }

}
