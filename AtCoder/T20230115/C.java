package AtCoder.T20230115;

import java.io.*;

public class C {

    // 题目大意: 给你一个字符串S 只包含大写字母 求S的价值 每一步都要 * 26 + 当前价值, 最后一个字符除外
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

    static String S;

    public static void main(String[] args) throws IOException {
        S = nextString();
        int n = S.length();
        long add = 1L, ans = 0L;
        for (int i = 0; i < n - 1; i++) {
            add = add * 26;
        }
        for (int i = 0; i < n; i++) {
            long v = S.charAt(i) - 'A' + 1;
            v *= add; add /= 26;
            ans += v;
        }
        out.print(ans);
        out.close();
    }
}
