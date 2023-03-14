package BigChang;

import java.io.*;

public class P1077 {

//    美团春招-2023.3.11-第一题-字符串修改

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

    public static void main(String[] args) throws IOException {
        var s = nextString();
        var ss = s.toCharArray();
        int ans = 0;
        for (int i = 1; i < ss.length; i++) {
            if (ss[i] == ss[i - 1]) {
                ans++;
                ss[i] = 'x';
            }
        }
        out.print(ans);
        out.close();
    }
}
