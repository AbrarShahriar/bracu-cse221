import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
    public static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
        int[] NMSDK = readInts(5);
        int N = NMSDK[0], M = NMSDK[1], S = NMSDK[2], D = NMSDK[3], K = NMSDK[4];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] uv = readInts(2);
            int u = uv[0], v = uv[1];
            list.get(u).add(v);
        }

        int[] prevFromS = BFS(list, S);
        int[] prevFromK = BFS(list, K);

        if (prevFromS[K] == -2 || prevFromK[D] == -2) {
            pw.print("-1");
            pw.flush();
            return;
        }

        LinkedList<Integer> path1 = reconstruct(prevFromS, S, K);
        LinkedList<Integer> path2 = reconstruct(prevFromK, K, D);

        if (path1 == null || path2 == null) {
            pw.print("-1");
            pw.flush();
            return;
        }

        ArrayList<Integer> finalPath = new ArrayList<Integer>();
        finalPath.addAll(path1);
        for (int i = 1; i < path2.size(); i++) {
            finalPath.add(path2.get(i));
        }

        pw.println(finalPath.size() - 1);
        for (int i = 0; i < finalPath.size(); i++) {
            pw.print(finalPath.get(i) + " ");
        }

        pw.flush();
    }

    public static int[] BFS(ArrayList<ArrayList<Integer>> list, int source) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] prev = new int[list.size()];
        Arrays.fill(prev, -2);

        prev[source] = -1;
        queue.add(source);

        while (!queue.isEmpty()) {
            int u = queue.remove();

            ArrayList<Integer> neighbours = list.get(u);
            for (int i = 0; i < neighbours.size(); i++) {
                int v = neighbours.get(i);
                if (prev[v] == -2) {
                    prev[v] = u;
                    queue.add(v);
                }
            }
        }

        return prev;
    }

    public static LinkedList<Integer> reconstruct(int[] prev, int source, int destination) {
        if (prev[destination] == -2)
            return null;

        LinkedList<Integer> path = new LinkedList<Integer>();
        int temp = destination;
        while (temp != -1) {
            path.addFirst(temp);
            temp = prev[temp];
        }
        return path;
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
