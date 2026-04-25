
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class C {
    public static int R = 0, C = 0;
    public static int[] deltaX = { -1, 1, 2, 2, 1, -1, -2, -2 };
    public static int[] deltaY = { -2, -2, -1, 1, 2, 2, 1, -1 };

    public static void main(String[] args) throws Exception

    {

        int N = FastIO.readInt();
        R = N;
        C = N;

        int[] xys = FastIO.readInts(4);
        int x1 = xys[0], y1 = xys[1], x2 = xys[2], y2 = xys[3];

        int[][] visited = new int[N + 1][N + 1];
        int[][] dist = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(visited[i], -1);
            Arrays.fill(dist[i], -1);
        }

        BFS(visited, dist, new int[] { x1, y1 }, new int[] { x2, y2 });

        if (visited[x2][y2] == -1 || dist[x2][y2] < 0) {
            FastIO.write("-1");
            FastIO.close();
            return;
        }

        FastIO.write(dist[x2][y2]);
        FastIO.close();
    }

    public static void BFS(int[][] visited, int[][] dist, int[] node, int[] target) {

        visited[node[0]][node[1]] = 1;
        dist[node[0]][node[1]] = 0;

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int[] u = queue.poll();

            for (int i = 0; i < deltaX.length; i++) {
                int newX = u[0] + deltaX[i], newY = u[1] + deltaY[i];
                int[] move = { newX, newY };
                if (isValid(newX, newY) && visited[move[0]][move[1]] == -1) {
                    visited[move[0]][move[1]] = 1;
                    dist[move[0]][move[1]] = dist[u[0]][u[1]] + 1;
                    queue.add(move);
                }
            }

        }
    }

    public static boolean isValid(int x, int y) {
        return 0 < x && x <= R && 0 < y && y <= C;
    }
}
