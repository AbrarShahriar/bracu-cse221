public class G {
    public static int ROW_BOUND, COL_BOUND;

    public static void main(String[] args) throws Exception {
        int[] inputs = FastIO.readInts(3);

        int N = inputs[0], M = inputs[1], K = inputs[2];
        ROW_BOUND = N;
        COL_BOUND = M;

        int[][] mat = new int[N + 1][M + 1];

        int[][] knightCoords = new int[K][2];
        int knightCount = 0;
        for (int i = 0; i < K; i++) {
            int[] coords = FastIO.readInts(2);
            int x = coords[0], y = coords[1];
            mat[x][y] = 1;
            knightCoords[knightCount] = new int[] { x, y };
            knightCount++;
        }

        int[] xDelta = { -1, 1, 2, 2, 1, -1, -2, -2 };
        int[] yDelta = { -2, -2, -1, 1, 2, 2, 1, -1 };
        boolean isAttacking = false;

        for (int i = 0; i < knightCount; i++) {
            int[] curKnightCoord = knightCoords[i];

            for (int j = 0; j < xDelta.length; j++) {
                int[] curKnightNewCoord = new int[] { curKnightCoord[0] + xDelta[j], curKnightCoord[1] + yDelta[j] };
                if (isValidPosition(curKnightNewCoord[0], curKnightNewCoord[1])) {
                    if (mat[curKnightNewCoord[0]][curKnightNewCoord[1]] == 1) {
                        isAttacking = true;
                        break;
                    }
                }
            }
            if (isAttacking)
                break;
        }

        if (isAttacking) {
            FastIO.writeLn("YES");
        } else {
            FastIO.writeLn("NO");
        }
        FastIO.close();

    }

    public static boolean isValidPosition(int x, int y) {
        return (x > 0 && x <= ROW_BOUND) && (y > 0 && y <= COL_BOUND);
    }
}