
public class E {
    public static void main(String[] args) throws Exception {
        int[] NM = FastIO.readInts(2);
        int N = NM[0];
        int M = NM[1];

        int[] u = FastIO.readInts(M);
        int[] v = FastIO.readInts(M);

        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            inDegree[v[i]]++;
            outDegree[u[i]]++;
        }

        int[] difference = new int[N + 1];

        for (int i = 1; i < difference.length; i++) {
            difference[i] = inDegree[i] - outDegree[i];
            FastIO.write(difference[i] + " ");
        }

        FastIO.close();
    }
}
