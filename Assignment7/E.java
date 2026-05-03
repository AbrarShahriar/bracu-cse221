import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class E {

    public static void main(String[] args) throws Exception {
        int[] NM = FastIO.readInts(2);
        int N = NM[0], M = NM[1];

        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++)
            list.add(new ArrayList<>());

        int[] us = FastIO.readInts(M);
        int[] vs = FastIO.readInts(M);
        int[] ws = FastIO.readInts(M);
        for (int i = 0; i < us.length; i++) {
            list.get(us[i]).add(new Integer[] { vs[i], ws[i] });
        }

        dijkstras(list, 1, N);

        FastIO.close();

    }

    public static void dijkstras(ArrayList<ArrayList<Integer[]>> list, int src, int dst) throws Exception {
        int[] dist = new int[list.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        dist[src] = 0;
        pq.add(new Integer[] { src, dist[src] });

        while (!pq.isEmpty()) {
            Integer[] curEntry = pq.poll();
            int u = curEntry[0], du = curEntry[1];

            if (du > dist[u])
                continue;

            for (Integer[] neighbourEntry : list.get(u)) {
                int v = neighbourEntry[0], dv = neighbourEntry[1];
                int newDist = dist[u] + dv;
                if (newDist < dist[v] && (bothEven(du, dv) || bothOdd(du, dst))) {
                    dist[v] = newDist;
                    pq.add(new Integer[] { v, dist[v] });
                }
            }
        }

        FastIO.writeLn(dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst]);

    }

    public static boolean bothEven(int x, int y) {
        return x % 2 == 0 && y % 2 == 0;
    }

    public static boolean bothOdd(int x, int y) {
        return x % 2 != 0 && y % 2 != 0;
    }
}