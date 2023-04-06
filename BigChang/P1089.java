package BigChang;

import java.io.*;

public class P1089 {

//    美团校招-2023.3.18.10点-第三题-小美的回文串

    static void solve(String s) {
        var ss = s.toCharArray();
        int n = ss.length;
        int c = 0;
        for (int i = 0; i <= n / 2; i++) {
            if (ss[i] != ss[n - i - 1]) c++;
        }
        if (c == 0) {
            for (int i = 0; i < n; i++) {
                if (ss[i] != 'a') {
                    ss[i] = 'a';
                    ss[n - i - 1] = 'a';
                    break;
                }
            }
        } else if (c == 1) {
            for (int i = 0; i < n; i++) {
                if (ss[i] != ss[n - i - 1]) {
                    if (ss[i] == 'a' || ss[n - i - 1] == 'a') {
                        if (n % 2 == 1) ss[n / 2] = 'a';
                    }
                    ss[i] = 'a';
                    ss[n - i - 1] = 'a';
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (ss[i] != ss[n - i - 1]) {
                    ss[i] = (char) Math.min(ss[i], ss[n - i - 1]);
                    ss[n - i - 1] = ss[i];
                }
            }
        }
        out.print(String.valueOf(ss));
    }


    public static void main(String[] args) throws IOException {
        var s = nextString();
        solve(s);
        out.close();
    }



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
}
