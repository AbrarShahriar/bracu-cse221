
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B {
    public static void main(String[] args) throws Exception {
        int[] NM = FastIO.readInts(2);
        int N = NM[0], M = NM[1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++)
            list.add(new ArrayList<Integer>());

        for (int m = 0; m < M; m++) {
            int[] uv = FastIO.readInts(2);
            int u = uv[0], v = uv[1];
            list.get(u).add(v);
        }

        int[] hr = { 0, 0 };
        char[] role = new char[N + 1];
        Arrays.fill(role, 'u');
        for (int i = 1; i < list.size(); i++) {
            if (role[i] == 'u') {
                BFS(list, role, hr, i);

            }
        }

        FastIO.write(Math.max(hr[0], hr[1]));
        FastIO.close();

    }

    public static void BFS(ArrayList<ArrayList<Integer>> list, char[] role, int[] hr, int node) {

        role[node] = 'h';
        hr[0]++;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : list.get(u)) {
                if (role[u] == 'h' && role[v] == 'u') {
                    role[v] = 'r';
                    queue.add(v);
                    hr[1]++;
                } else if (role[u] == 'r' && role[v] == 'u') {
                    role[v] = 'h';
                    queue.add(v);
                    hr[0]++;
                }
            }

        }
    }
}