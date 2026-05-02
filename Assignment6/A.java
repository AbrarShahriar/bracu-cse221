import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class A {
    public static boolean cycleFound = false;

    public static void main(String[] args) throws Exception {
        int T = FastIO.readInt();

        for (int t = 0; t < T; t++) {
            int[] NM = FastIO.readInts(2);
            int N = NM[0], M = NM[1];

            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(N + 1);
            for (int i = 0; i < N + 1; i++) {
                list.add(new ArrayList<Integer>());
            }

            int[] inDegree = new int[N + 1];
            for (int m = 0; m < M; m++) {
                int[] ab = FastIO.readInts(2);
                int a = ab[0], b = ab[1];

                list.get(a).add(b);
                inDegree[b]++;
            }

            ArrayList<Integer> path = topoSortKahn(list, inDegree);
            if (path == null) {
                FastIO.writeLn("-1");
                continue;
            }
            for (int p : path) {
                FastIO.write(p + " ");
            }
            FastIO.writeLn("");
        }

        FastIO.close();
    }

    public static ArrayList<Integer> topoSortKahn(ArrayList<ArrayList<Integer>> list, int[] inDegree) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < list.size(); i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int a = queue.poll();
            count++;
            result.add(a);

            for (int b : list.get(a)) {
                inDegree[b]--;
                if (inDegree[b] == 0) {
                    queue.add(b);
                }
            }
        }

        if (count != list.size() - 1) {
            return null;
        }

        return result;
    }

}
