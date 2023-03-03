package AtCoder.T20230226;


import java.io.*;
import java.util.Arrays;

public class B {

//    B - Trimmed Mean

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
    static int[] a;

    public static void main(String[] args) throws IOException {
        N = nextInt();
        a = new int[5 * N];
        for (int i = 0; i < a.length; i++) a[i] = nextInt();
        Arrays.sort(a);
        int cnt = N;
        int i = 0, j = a.length - 1, sum = 0;
        while (cnt > 0) { i++; j--; cnt--; }
        for (; i <= j; i++) sum += a[i];
        out.print(sum / (a.length - 2.0 * N));
        out.close();
    }
}