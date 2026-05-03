import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class F {
    public static void main(String[] args) throws Exception {
        int[] NMSD = FastIO.readInts(4);
        int N = NMSD[0], M = NMSD[1], S = NMSD[2], D = NMSD[3];

        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int[] uvw = FastIO.readInts(3);
            int u = uvw[0], v = uvw[1], w = uvw[2];
            list.get(u).add(new Integer[] { v, w });
            list.get(v).add(new Integer[] { u, w });
        }

        dijkstras(list, S, D);
        FastIO.close();
    }

    public static void dijkstras(ArrayList<ArrayList<Integer[]>> list, int src, int dst) throws Exception {
        int[] dist1 = new int[list.size()];
        int[] dist2 = new int[list.size()];

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        dist1[src] = 0;
        pq.add(new Integer[] { src, 0 });

        while (!pq.isEmpty()) {
            Integer[] curEntry = pq.poll();
            int u = curEntry[0], du = curEntry[1];

            if (du > dist2[u])
                continue;

            for (Integer[] neighbourEntry : list.get(u)) {
                int v = neighbourEntry[0], dv = neighbourEntry[1];
                if (du + dv < dist1[v]) {
                    dist2[v] = dist1[v];
                    dist1[v] = du + dv;
                    pq.add(new Integer[] { v, dist1[v] });
                    pq.add(new Integer[] { v, dist2[v] });
                } else if (du + dv > dist1[v] && du + dv < dist2[v]) {
                    dist2[v] = du + dv;
                    pq.add(new Integer[] { v, dist2[v] });
                }
            }
        }

        FastIO.writeLn(dist2[dst] == Integer.MAX_VALUE ? -1 : dist2[dst]);
    }
}
