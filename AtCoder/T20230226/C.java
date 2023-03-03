package AtCoder.T20230226;


import java.io.*;
import java.util.HashSet;

public class C {

//    C - LRUD Instructions 2

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
    static String S;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        N = nextInt(); S = nextString();
        set.add("0_0");
        int x = 0, y = 0;
        var ans = "No";
        for (char c : S.toCharArray()) {
            String p;
            if (c == 'R') x++;
            if (c == 'L') x--;
            if (c == 'U') y++;
            if (c == 'D') y--;
            p = x + "_" + y;
            if (set.contains(p)) { ans = "Yes"; break; }
            set.add(p);
        }
        out.print(ans);
        out.close();
    }
}