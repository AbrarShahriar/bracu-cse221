import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class G {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
    public static StringTokenizer st = null;
    public static boolean found = false;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String A = st.nextToken();
        String B = st.nextToken();

        String[] words = new String[N];
        Map<String, Integer> wordsIdx = new HashMap<String, Integer>();
        for (int n = 0; n < N; n++) {
            String word = br.readLine().trim();
            words[n] = word;
            wordsIdx.put(word, n);
        }

        int total = N + 26;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int idOfFirstChar = words[i].charAt(0) - 'A';
            int idOfLastChar = words[i].charAt(words[i].length() - 1) - 'A';

            list.get(idOfFirstChar + N).add(i);
            list.get(i).add(idOfLastChar + N);
        }

        int source = wordsIdx.get(A);
        int destination = wordsIdx.get(B);

        BFS(list, source, destination);

        if (found) {
            pw.print("YES");
        } else {
            pw.print("NO");
        }

        pw.close();
    }

    public static void BFS(ArrayList<ArrayList<Integer>> list, int source, int destination) {
        int[] visited = new int[list.size()];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new ArrayDeque<Integer>();

        visited[source] = 1;
        queue.add(source);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (u == destination) {
                found = true;
                break;
            }

            for (int v : list.get(u)) {
                if (v == u) {
                    found = true;
                    break;
                }
                if (visited[v] == -1) {
                    visited[v] = 1;
                    queue.add(v);
                }
            }
        }
    }
}
