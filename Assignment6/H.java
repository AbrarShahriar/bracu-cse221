import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class H {
    public static void main(String[] args) throws Exception {
        int N = FastIO.readInt();

        String[] words = new String[N];
        for (int n = 0; n < N; n++) {
            words[n] = FastIO.readString();
        }

        Set<Character> charSet = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charSet.add(c);
            }
        }

        Map<Character, Set<Character>> list = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (char c : charSet) {
            list.put(c, new HashSet<>());
            inDegree.put(c, 0);
        }

        // adjacent word constraint defining
        for (int i = 0; i < N - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            boolean foundDiff = false;
            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!list.get(c1).contains(c2)) {
                        list.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    foundDiff = true;
                    break;
                }
            }

            if (!foundDiff && w1.length() > w2.length()) {
                FastIO.write("-1");
                FastIO.close();
                return;
            }

        }

        // Topo sort for lexicography
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (char c : charSet) {
            if (inDegree.get(c) == 0) {
                pq.offer(c);
            }
        }

        ArrayList<Character> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            char u = pq.poll();
            result.add(u);
            for (char v : list.get(u)) {
                inDegree.put(v, inDegree.get(v) - 1);
                if (inDegree.get(v) == 0) {
                    pq.offer(v);
                }
            }
        }

        if (result.size() != charSet.size()) {
            FastIO.write("-1");
            FastIO.close();
            return;
        }

        for (char ch : result) {
            FastIO.write(ch);
        }

        FastIO.close();
    }
}
