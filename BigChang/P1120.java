package BigChang;

import java.io.*;
import java.util.StringTokenizer;

public class P1120 {


//    2023.03.26-第一题-密码学

    static int mod = 26;

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        String s = in.next();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int temp = 'a' + (s.charAt(i) - 'a' - 3 + mod) % mod;
            ans.append((char) temp);
        }
        out.print(ans);
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
