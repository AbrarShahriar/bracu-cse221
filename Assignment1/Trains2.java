
import java.util.Arrays;

public class Trains2 {
    public static void main(String[] args) throws Exception {
        int N = FastIO.readInt();

        String[][] trains = new String[N][3];

        for (int i = 0; i < N; i++) {
            String line = FastIO.readString();
            String[] els = line.split(" ");
            for (int j = 0; j < N; j++) {
                trains[j][0] = els[0]; // name
                trains[j][1] = els[4]; // destination
                trains[j][2] = els[6]; // time
            }

            Arrays.sort(trains, (train1, train2) -> train1[0].compareTo(train2[0]));

        }

        for (int i = 0; i < trains.length; i++) {
            System.out.println(trains[0] + " will depart for " + trains[1] + " at " + trains[2]);
        }

        FastIO.close();
    }
}
