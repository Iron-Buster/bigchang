package AtCoder.T20230226;


import java.io.*;

public class A {

//    A - camel Case

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
        String s = nextString();
        int ans = 1;
        for (var c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') break;
            ans++;
        }
        out.print(ans);
        out.close();
    }

}