import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
    public static StringTokenizer st = null;

    public static boolean foundCycle = false;

    public static void main(String[] args) throws IOException {
        int[] NM = readInts(2);
        int N = NM[0], M = NM[1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            int[] uv = readInts(2);
            int u = uv[0], v = uv[1];
            list.get(u).add(v);
        }

        String[] state = new String[N + 1];
        Arrays.fill(state, "WHITE");

        for (int i = 1; i < state.length; i++) {
            if (state[i].equals("WHITE")) {
                DFS(list, state, i);
            }
        }

        if (foundCycle) {
            pw.println("YES");
        } else {
            pw.println("NO");
        }
        pw.flush();
    }

    public static void DFS(ArrayList<ArrayList<Integer>> list, String[] state, int u) {
        state[u] = "GRAY";

        ArrayList<Integer> vs = list.get(u);
        for (int v : vs) {
            if (state[v].equals("WHITE")) {
                DFS(list, state, v);
            }
            if (state[v].equals("GRAY")) {
                foundCycle = true;
            }
        }

        state[u] = "BLACK";
    }

    public static int[] readInts(int numOfInput) throws IOException {
        st = new StringTokenizer(br.readLine());
        int[] inputs = new int[numOfInput];
        for (int i = 0; i < numOfInput; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        return inputs;
    }

    public static int readInt() throws NumberFormatException, IOException {
        return Integer.parseInt(br.readLine());
    }
}
