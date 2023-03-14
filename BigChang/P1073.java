package BigChang;

import java.io.*;
import java.util.HashMap;

public class P1073 {
    // 2023 3/12 滴滴笔试题 P1

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

    public static void main(String[] args) throws IOException {
        int n = nextInt(), k = nextInt();
        var map = new HashMap<Long, Integer>();
        for (int i = 0; i < n; i++) {
            long x = nextLong();
            map.merge(x, 1, Integer::sum);
        }
        int ans = 0;
        for (var e : map.entrySet()) {
            if (e.getValue() > k) {
                ans += e.getValue() - k;
            }
        }
        out.print(ans);
        out.close();
    }
}
