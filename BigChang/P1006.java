package BigChang;

import java.io.*;
import java.util.StringTokenizer;

public class P1006 {


//    2022.9.21-数组取min
    static int[] a = new int[100001];

    static void solve(int n, int tot) {
        int l = 0;
        int r = 100001;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        if (sum <= tot) {
            out.print(-1);
            return;
        }
        while (l < r) {
            int mid = l + r + 1>> 1;
            if (check(n, tot, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        out.print(l);
    }

    static boolean check(int n, int tot, int mid) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(a[i], mid);
        }
        return sum <= tot;
    }

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int tot = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        solve(n, tot);
        out.close();
    }


    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
