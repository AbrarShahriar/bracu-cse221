import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws Exception {
        int[] NM = FastIO.readInts(2);
        int N = NM[0], M = NM[1];

        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int[] uvw = FastIO.readInts(3);
            int u = uvw[0], v = uvw[1], w = uvw[2];
            list.get(u).add(new Integer[] { v, w });
            list.get(v).add(new Integer[] { u, w });
        }

        dijkstras(list, 1);

        FastIO.close();

    }

    public static void dijkstras(ArrayList<ArrayList<Integer[]>> list, int src) throws Exception {
        int[] dist = new int[list.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        dist[src] = 0;
        pq.add(new Integer[] { src, 0 });

        while (!pq.isEmpty()) {
            Integer[] curEntry = pq.poll();
            int u = curEntry[0], du = curEntry[1];

            for (Integer[] neighbourEntry : list.get(u)) {
                int v = neighbourEntry[0], dv = neighbourEntry[1];
                int newDist = Math.max(du, dv);
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(new Integer[] { v, dist[v] });
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            FastIO.write(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
            FastIO.write(" ");
        }
        FastIO.writeLn("");

    }
}