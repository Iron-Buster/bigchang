package BigChang;

import java.io.*;
import java.util.Arrays;

public class P1079 {
//    百度2023春招-2023.3.13-第一题-字符串重排
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
        return ins.readLine();
    }

    static final char[] tt = {'B', 'a', 'i', 'd', 'u'};
    static { Arrays.sort(tt); }

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            var ss = nextString().toCharArray();
            if (ss.length != tt.length) {
                out.println("No");
            } else {
                Arrays.sort(ss);
                var ok = true;
                for (int i = 0; i < tt.length; i++) {
                    if (ss[i] != tt[i]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) out.println("Yes");
                else out.println("No");
            }
        }
        out.close();
    }
}
