package AtCoder.T20230115;

import java.io.*;

public class B {

//    B - Longest Uncommon Prefix

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
    static char[] c;

    public static void main(String[] args) throws IOException {
        N = nextInt();
        c = nextString().toCharArray();
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i + j > N) { out.print(j - 1 + "\n"); break; }
                if (c[j - 1] == c[j + i - 1]) { out.print(j - 1 + "\n"); break; }
            }
        }
        out.close();
    }
}
