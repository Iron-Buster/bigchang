package AtCoder.T20230304;

import java.io.*;

public class B {

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
    static int Q;
    public static void main(String[] args) throws IOException {
        var r = new int[110];
        var y = new int[110];
        N = nextInt();
        Q = nextInt();
        while (Q-- > 0) {
            int event = nextInt();
            int x = nextInt();
            if (event == 1) {
                y[x]++;
            } else if (event == 2) {
                r[x]++;
            } else if (event == 3) {
                if (y[x] > 1 || r[x] > 0) { out.print("Yes\n"); }
                else                      { out.print("No\n");}
            }
        }
        out.close();
    }
}
