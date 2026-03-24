
import java.util.LinkedList;
import java.util.Queue;

public class ArithmeticExpression {
    public static void main(String[] args) throws Exception {
        int T = FastIO.readInt();
        for (int i = 0; i < T; i++) {
            String expression = FastIO.readString();
            Queue<Float> numQueue = new LinkedList<>();
            Queue<Character> funcQueue = new LinkedList<>();

            float a = 0;
            for (int j = 0; j < expression.length(); j++) {
                char ch = expression.charAt(j);
                if (ch == ' ' || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                    continue;

                if (ch == '+') {
                    numQueue.offer(a);
                    funcQueue.offer(ch);
                    a = 0;
                    continue;
                } else if (ch == '-') {
                    numQueue.offer(a);
                    funcQueue.offer(ch);
                    a = 0;
                    continue;
                } else if (ch == '*') {
                    numQueue.offer(a);
                    funcQueue.offer(ch);
                    a = 0;
                    continue;
                } else if (ch == '/') {
                    numQueue.offer(a);
                    funcQueue.offer(ch);
                    a = 0;
                    continue;
                }

                if (Character.isDigit(ch)) {
                    a = ch - '0';

                    for (int k = j + 1; k < expression.length(); k++) {
                        char cur = expression.charAt(k);
                        if (Character.isDigit(cur)) {
                            a = 10 * a + (cur - '0');
                            j++;
                        } else {
                            break;
                        }
                    }
                }

                if (j == expression.length() - 1)
                    numQueue.offer(a);
            }

            float result = 0;

            while (!funcQueue.isEmpty()) {
                float x = numQueue.poll();
                float y = numQueue.poll();
                char op = funcQueue.poll();

                switch (op) {
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break;
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        result = x / y;
                        break;
                    default:
                        result = 0;
                }

                numQueue.offer(result);
            }

            FastIO.writeLn(result);
        }

        FastIO.close();
    }
}
