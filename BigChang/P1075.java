package BigChang;

import java.io.*;
import java.util.Arrays;

public class P1075 {

//    拼多多春招-2023.3.12-飞机大战

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
        int t = nextInt();
        int n = nextInt();
        int[] a = new int[n];
        while (t-- > 0) {
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            Arrays.sort(a);
            int ans = 0, i = 0;
            for (; i < n; i++) {
                if (a[i] >= 2) break;   // 后面全用B
                else if (a[i] == 1) {   // 使用A
                    ans++;
                    if (i + 1 < n) a[i+1]--; // 后面一发子弹
                }
            }
            out.print(ans + n - i + "\n");
        }
        out.close();
    }
}
