import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D {
    public static int[] ws;

    public static void main(String[] args) throws Exception {
        int[] NMSD = FastIO.readInts(4);
        int N = NMSD[0], M = NMSD[1], S = NMSD[2], D = NMSD[3];

        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++)
            list.add(new ArrayList<>());

        ws = new int[N + 1];
        int[] inputWs = FastIO.readInts(N);
        for (int i = 0; i < inputWs.length; i++) {
            ws[i + 1] = inputWs[i];
        }

        for (int i = 0; i < M; i++) {
            int[] uv = FastIO.readInts(2);
            int u = uv[0], v = uv[1];
            list.get(u).add(new Integer[] { v, 0 });
        }

        dijkstras(list, S, D);

        FastIO.close();

    }

    public static void dijkstras(ArrayList<ArrayList<Integer[]>> list, int src, int dst) throws Exception {
        int[] dist = new int[list.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        dist[src] = ws[src];
        pq.add(new Integer[] { src, dist[src] });

        while (!pq.isEmpty()) {
            Integer[] curEntry = pq.poll();
            int u = curEntry[0], du = curEntry[1];

            if (du > dist[u])
                continue;

            for (Integer[] neighbourEntry : list.get(u)) {
                int v = neighbourEntry[0];
                int newDist = dist[u] + ws[v];
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(new Integer[] { v, dist[v] });
                }
            }
        }

        FastIO.writeLn(dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst]);

    }
}