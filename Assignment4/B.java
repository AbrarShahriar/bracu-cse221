import java.util.ArrayList;

public class B {
    public static void main(String[] args) throws Exception {
        int[] NM = FastIO.readInts(2);
        int N = NM[0];
        int M = NM[1];

        ArrayList<ArrayList<Integer[]>> list = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; i++) {
            ArrayList<Integer[]> node = new ArrayList<>();
            list.add(node);
        }

        int[] us = FastIO.readInts(M);
        int[] vs = FastIO.readInts(M);
        int[] ws = FastIO.readInts(M);

        for (int i = 0; i < M; i++) {
            if (list.get(us[i]) == null) {
                ArrayList<Integer[]> node = new ArrayList<>();
                Integer v = vs[i], w = ws[i];
                Integer[] a = { v, w };
                node.add(a);
                list.add(us[i], node);
            } else {
                Integer v = vs[i], w = ws[i];
                Integer[] a = { v, w };
                list.get(us[i]).add(a);
            }
        }

        for (int i = 1; i < list.size(); i++) {
            FastIO.write(i + ": ");
            ArrayList<Integer[]> edges = list.get(i);
            for (int j = 0; j < edges.size(); j++) {
                FastIO.write("(" + edges.get(j)[0] + "," + edges.get(j)[1] + ") ");
            }
            FastIO.writeLn("");
        }

        FastIO.close();
    }
}
