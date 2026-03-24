public class A {
    public static void main(String[] args) throws Exception {
        int[] NM = FastIO.readInts(2);
        int N = NM[0];
        int M = NM[1];

        int[][] mat = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int[] uvw = FastIO.readInts(3);

            int u = uvw[0];
            int v = uvw[1];
            int w = uvw[2];

            mat[u][v] = w;
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat.length; j++) {
                FastIO.write(mat[i][j] + " ");
            }
            FastIO.writeLn("");
        }

        FastIO.close();
    }
}