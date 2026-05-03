import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B {
    public static void main(String[] args) throws Exception {
        int[] NMST = FastIO.readInts(4);
        int N = NMST[0], M = NMST[1], S = NMST[2], T = NMST[3];

        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>();
        for (int index = 0; index < N + 1; index++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int[] uvw = FastIO.readInts(3);
            int u = uvw[0], v = uvw[1], w = uvw[2];
            list.get(u).add(new Integer[] { v, w });
        }

        int[] distS = dijkstrasDist(list, S);
        int[] distT = dijkstrasDist(list, T);

        int bestTime = Integer.MAX_VALUE;
        int bestNode = -1;
        for (int n = 1; n < N + 1; n++) {
            if (distS[n] < Integer.MAX_VALUE && distT[n] < Integer.MAX_VALUE) {
                int time = Math.max(distS[n], distT[n]);
                if (time < bestTime || (time == bestTime && n < bestNode)) {
                    bestTime = time;
                    bestNode = n;
                }
            }
        }

        if (bestNode == -1) {
            FastIO.writeLn(-1);
        } else {
            FastIO.writeLn(bestTime + " " + bestNode);
        }

        FastIO.close();
    }

    public static int[] dijkstrasDist(ArrayList<ArrayList<Integer[]>> list, int src) throws Exception {
        int[] dist = new int[list.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        dist[src] = 0;
        pq.add(new Integer[] { src, 0 });

        while (!pq.isEmpty()) {
            Integer[] curEntry = pq.poll();
            int u = curEntry[0];

            for (Integer[] neighbourEntry : list.get(u)) {
                int v = neighbourEntry[0], dv = neighbourEntry[1];
                if (dist[u] + dv < dist[v]) {
                    dist[v] = dist[u] + dv;
                    pq.add(new Integer[] { v, dist[v] });
                }
            }
        }

        return dist;
    }

}
