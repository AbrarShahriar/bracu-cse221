import java.util.HashMap;

public class TripleTheTrouble {
    public static void main(String[] args) throws Exception {
        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        int n = Integer.parseInt(els1[0]);
        long x = Integer.parseInt(els1[1]);

        String input2 = FastIO.readString();
        String[] els2 = input2.split(" ");
        long[] arr = new long[n];
        for (int j = 0; j < els2.length; j++) {
            arr[j] = Long.parseLong(els2[j]);
        }

        boolean found = false;
        int[] tuple = { -1, -1, -1 };
        HashMap<Long, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (found)
                break;

            for (int j = i + 1; j < arr.length; j++) {
                long remaining = x - arr[i] - arr[j];

                if (seen.containsKey(remaining)) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr[k] == remaining) {
                            tuple[0] = i + 1;
                            tuple[1] = j + 1;
                            tuple[2] = k + 1;
                            found = true;
                            break;
                        }
                    }
                    if (found)
                        break;
                }
                seen.put(arr[j], j);
            }

        }

        if (found) {
            FastIO.writeLn(tuple[0] + " " + tuple[1] + " " + tuple[2]);
        } else {
            FastIO.writeLn(-1);
        }
        FastIO.close();
    }
}
