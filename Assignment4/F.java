import java.util.ArrayList;

public class F {
    public static int N = 0;

    public static void main(String[] args) throws Exception {
        N = FastIO.readInt();
        int[] coordinates = FastIO.readInts(2);
        int x = coordinates[0], y = coordinates[1];

        ArrayList<Position> validMoves = new ArrayList<>();

        int[] xDelta = { 0, 1, 0, -1, -1, 1, 1, -1 }; // up right down left tl tr br bl
        int[] yDelta = { -1, 0, 1, 0, -1, -1, 1, 1 };

        for (int i = 0; i < xDelta.length; i++) {
            int newX = x + xDelta[i];
            int newY = y + yDelta[i];
            Position newPos = new Position(newX, newY);

            if (isValidPosition(newPos)) {
                validMoves.add(newPos);
            }
        }

        bubbleSort(validMoves);

        FastIO.writeLn(validMoves.size());
        for (int i = 0; i < validMoves.size(); i++) {
            FastIO.writeLn(validMoves.get(i).x + " " + validMoves.get(i).y);
        }
        FastIO.close();
    }

    public static boolean isValidPosition(Position p) {
        return (p.x > 0 && p.x <= N) && (p.y > 0 && p.y <= N);
    }

    public static void bubbleSort(ArrayList<Position> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if ((arr.get(j).x > arr.get(j + 1).x)
                        || (arr.get(j).x == arr.get(j + 1).x && arr.get(j).y > arr.get(j + 1).y)) {
                    Position temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }
}

class Position {
    int x, y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

}