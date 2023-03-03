package AtCoder.T20230115;

import java.io.*;
import java.util.HashMap;

public class D {

    // 题意：给你两组字符串 每两个字符串直连关系 判断所有字符串之间是否互相引用 -> 并查集判环
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

    static UnionFind u;
    static int N;

    public static void main(String[] args) throws IOException {
        u = new UnionFind();
        N = nextInt();
        while (N-- > 0) {
            var a = nextString();
            var b = nextString();
            if (u.isConnected(a, b)) { out.print("No"); out.close(); return; }
            u.union(a, b);
        }
        out.print("Yes");
        out.close();
    }

    static class UnionFind {
        HashMap<String, String> fa;

        public UnionFind() {
            fa = new HashMap<>();
        }

        String find(String x) {
           if (!fa.containsKey(x)) fa.put(x, x);
           while (!x.equals(fa.get(x))) {
               x = fa.get(fa.get(x));
           }
           return x;
        }

        void union(String a, String b) {
            a = find(a);
            b = find(b);
            if (a.equals(b)) return;
            fa.put(b, a);
        }

        boolean isConnected(String a, String b) {
            return find(a).equals(find(b));
        }
    }
}
