package BigChang;

import java.io.*;
import java.util.StringTokenizer;

public class P1139 {


//    2023.04.01-第三题-塔子哥的收藏夹
    static int n;
    static int N = 500001;
    static int[] op = new int[N];
    static int[] x = new int[N];
    static int[] y = new int[N];

    public static void main(String[] args) throws IOException {
        // RMQ问题
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 1; i <= m; i++) op[i] = in.nextInt();
        for (int i = 1; i <= m; i++) x[i] = in.nextInt();
        for (int i = 1; i <= m; i++) y[i] = in.nextInt();
        BIT bit = new BIT(n);
        for (int i = 1; i <= m; i++) {
            int o = op[i];
            if (o == 0) {
                bit.update(x[i]-1, y[i]);
            } else {
                int ans = bit.sumRange(x[i]-1, y[i]-1);
                out.print(ans + " ");
            }
        }
        out.close();
    }

    static class BIT {
        int[] tree;
        int[] nums;
        int n;

        public BIT(int n) {
            this.n = n;
            nums = new int[n];
            tree = new int[n + 1];
        }

        int lowbit(int x) {
            return x & -x;
        }
        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                ans += tree[i];
            }
            return ans;
        }
        void add(int x, int u) {
            for (int i = x; i <= n; i += lowbit(i)) {
                tree[i] += u;
            }
        }

        public void update(int i, int val) {
            add(i+1, val - nums[i]);
            nums[i] = val;
        }

        public int sumRange(int l, int r) {
            return query(r + 1) - query(l);
        }
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
