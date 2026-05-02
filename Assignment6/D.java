import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class D {
    public static int diameter = 0;

    public static void main(String[] args) throws Exception {
        int N = FastIO.readInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int[] uv = FastIO.readInts(2);
            int u = uv[0], v = uv[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        int oneToDeepest = BFS(list, 1, false);
        int deepestToOtherDeepest = BFS(list, oneToDeepest, true);

        FastIO.write(diameter + "\n");
        FastIO.write(oneToDeepest + " " + deepestToOtherDeepest);
        FastIO.close();
    }

    public static int BFS(ArrayList<ArrayList<Integer>> list, int source, boolean calculateDiameter) {
        int[] visited = new int[list.size()];
        Arrays.fill(visited, -1);

        int[] dist = new int[list.size()];
        Arrays.fill(dist, -1);

        visited[source] = 1;
        dist[source] = 0;
        Queue<Integer> queue = new ArrayDeque<Integer>();

        queue.add(source);

        if (calculateDiameter)
            diameter++;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (calculateDiameter)
                diameter++;

            for (int v : list.get(u)) {
                if (visited[v] == -1) {
                    visited[v] = 1;
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                }
            }
        }

        int maxDist = 0;
        int deepestNode = source;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                deepestNode = i;
            }
        }

        if (calculateDiameter)
            diameter = maxDist;
        return deepestNode;
    }
}
