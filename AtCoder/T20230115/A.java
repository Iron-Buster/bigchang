package AtCoder.T20230115;

import java.io.*;

public class A {

    // 题意: 输入 a, b 判断a是否直连b output Yes : No
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
        int a = nextInt();
        int b = nextInt();
        if (a * 2 == b || a * 2 + 1 == b) out.print("Yes");
        else out.print("No");
        out.close();
    }
}
