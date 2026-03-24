
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws Exception {
        int N = FastIO.readInt();

        int[][] mat = new int[N][N];

        for (int i = 0; i < N; i++) {
            FastIO.st = new StringTokenizer(FastIO.br.readLine());
            int k = Integer.parseInt(FastIO.st.nextToken());

            for (int j = 0; j < k; j++) {
                int node = Integer.parseInt(FastIO.st.nextToken());
                mat[i][node] = 1;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                FastIO.write(mat[i][j] + " ");
            }
            FastIO.writeLn("");
        }

        FastIO.close();
    }
}
