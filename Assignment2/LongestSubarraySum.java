
public class LongestSubarraySum {
    public static void main(String[] args) throws Exception {
        String input1 = FastIO.readString();
        String[] els1 = input1.split(" ");
        int N = Integer.parseInt(els1[0]);
        long K = Integer.parseInt(els1[1]);

        String input2 = FastIO.readString();
        String[] els2 = input2.split(" ");
        int[] arr = new int[N];
        for (int j = 0; j < els2.length; j++) {
            arr[j] = Integer.parseInt(els2[j]);
        }

        int maxLen = 0;
        long currentSum = 0;
        int low = 0;

        for (int high = 0; high < arr.length; high++) {
            currentSum += arr[high];

            while (currentSum > K) {
                currentSum -= arr[low];
                low++;
            }

            if (currentSum <= K) {
                maxLen = Math.max(high - low + 1, maxLen);
            }
        }

        FastIO.writeLn(maxLen);
        FastIO.close();
    }

}
