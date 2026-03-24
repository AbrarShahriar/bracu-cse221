public class D {
    public static void main(String[] args) throws Exception {
        int[] NM = FastIO.readInts(2);
        int N = NM[0];
        int M = NM[1];

        int[] u = FastIO.readInts(M);
        int[] v = FastIO.readInts(M);

        int[] numOfDegreesForNode = new int[N + 1];

        for (int i = 0; i < M; i++) {
            numOfDegreesForNode[u[i]]++;
            numOfDegreesForNode[v[i]]++;
        }

        if (isEulerian(numOfDegreesForNode)) {
            FastIO.writeLn("YES");
        } else {
            FastIO.writeLn("NO");
        }
        FastIO.close();
    }

    public static boolean isEulerian(int[] numOfDegreesForNode) {
        int numOfOddDegreeNodes = 0;
        for (int i = 1; i < numOfDegreesForNode.length; i++) {
            if (numOfDegreesForNode[i] % 2 != 0)
                numOfOddDegreeNodes++;
        }
        return numOfOddDegreeNodes <= 2;
    }

}