import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FastIO {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);

    public static int readInt() throws Exception {
        return Integer.parseInt(br.readLine());
    }

    public static String readString() throws Exception {
        return (br.readLine());
    }

    public static void writeLn(Object str) throws Exception {
        pw.println(str);
    }

    public static void write(Object str) throws Exception {
        pw.print(str);
    }

    private static void flush() {
        pw.flush();
    }

    public static void close() {
        pw.close();
    }
}