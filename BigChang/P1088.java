package BigChang;

import java.io.*;
import java.util.HashMap;

public class P1088 {


//    美团校招-2023.3.18.10点-第二题-k彩色区间

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int k = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nextInt();
        solve(a, k);
        out.close();
    }

    static void solve(int[] a, int k) {
        int ans = 0;
        int i = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (i < a.length) {
            map.merge(a[i], 1, Integer::sum);
            while (map.size() > k) {
                map.put(a[j], map.get(a[j]) - 1);
                if (map.get(a[j]) == 0) map.remove(a[j]);
                j++;
            }
            ans = Math.max(ans, i - j + 1);
            i++;
        }
        out.print(ans);
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
