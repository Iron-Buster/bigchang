package BigChang;

import java.io.*;

public class P1078 {

//    美团春招-2023.3.11-第二题-天文爱好者 TODO

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
    static int N = 100001;
    static long[] diff = new long[N];
    static long[][] time;

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        time = new long[n][2];
        for (int i = 0; i < n; i++) time[i][0] = nextLong();
        for (int i = 0; i < n; i++) time[i][1] = nextLong();

    }
}
