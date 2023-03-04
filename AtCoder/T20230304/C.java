package AtCoder.T20230304;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class C {


    static BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(ins);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    public static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    public static String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }

    static int N;

    public static void main(String[] args) throws IOException {
        N = nextInt();
        Map<Long, Long> abCounts = new HashMap<>();
        for (long a = 1; a < N; a++) {
            for (long b = 1; b < N; b++) {
                long ab = a * b;
                if (ab > N) {
                    break;
                }
                abCounts.put(ab, abCounts.getOrDefault(ab, 0L) + 1);
            }
        }
        long ans = 0;
        for (long d = 1; d < N; d++) {
            for (long c = 1; c < N; c++) {
                long cd = c * d;
                if (cd >= N) {
                    break;
                }
                long ab = N - cd;
                if (abCounts.containsKey(ab)) {
                    ans += abCounts.get(ab);
                }
            }
        }
        out.print(ans);
        out.close();
    }
}
