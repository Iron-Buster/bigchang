package BigChang;

import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class P1138 {

//    2023.04.01-第二题-塔子哥的代数题
    static double[] a = new double[500001];
    static double[] sum = new double[500001];
    static DecimalFormat f = new DecimalFormat("#.0");

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextDouble();
            sum[i+1] = sum[i] + a[i];
        }
        int m = in.nextInt();
        while (m-- > 0) {
            int idx = in.nextInt();
            String opt = in.next();
//            double left = sum[idx-1], right = sum[n] - sum[idx+1];
            double ans = sum[idx-1] + sum[n] - sum[idx+1];
            if (opt.equals("+")) {
                ans = sum[n];
            } else if (opt.equals("-")) {
                ans = (sum[n] - sum[idx+1]) + sum[idx] - a[idx];
            } else if (opt.equals("*")) {
                ans += a[idx-1] * a[idx];
            } else if (opt.equals("/")) {
                ans += a[idx-1] / a[idx];
            }
            out.print(f.format(ans) + " ");
        }
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
