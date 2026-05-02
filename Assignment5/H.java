import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
    public static StringTokenizer st = null;

    public static Integer[] deltaR = { -1, 0, 1, 0 }, deltaC = { 0, 1, 0, -1 };
    public static int R, H;

    public static void main(String[] args) throws IOException {
        int[] RH = readInts(2);
        R = RH[0];
        H = RH[1];

        char[][] grid = new char[R][H];
        int[][] visited = new int[R][H];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int maxDiamond = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] == -1 && grid[i][j] != '#') {
                    int diamondCountOfComponent = BFS(new Integer[] { i, j }, grid, visited);
                    maxDiamond = Math.max(diamondCountOfComponent, maxDiamond);
                }
            }
        }

        pw.println(maxDiamond);
        pw.flush();
    }

    public static int BFS(Integer[] nodeCoord, char[][] grid, int[][] visited) {
        int count = 0;

        visited[nodeCoord[0]][nodeCoord[1]] = 1;

        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        queue.add(nodeCoord);

        while (!queue.isEmpty()) {
            Integer[] curNode = queue.remove();

            if (grid[curNode[0]][curNode[1]] == 'D')
                count++;

            for (int i = 0; i < 4; i++) {
                int newR = curNode[0] + deltaR[i], newC = curNode[1] + deltaC[i];
                if (isValidMove(newR, newC) && visited[newR][newC] != 1 && grid[newR][newC] != '#') {
                    visited[newR][newC] = 1;
                    queue.add(new Integer[] { newR, newC });
                }
            }
        }
        return count;
    }

    public static boolean isValidMove(int newR, int newC) {
        return 0 <= newR && newR < R && 0 <= newC && newC < H;
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