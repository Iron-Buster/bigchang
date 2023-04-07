package BigChang;

import java.io.*;
import java.util.StringTokenizer;

public class P1128 {

//    2023.03.26-第一题-塔子哥考试

    static String[] ss = new String[10001];
    static String[] tt = new String[10001];

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            ss[i] = in.next();
        }
        for (int i = 0; i < n; i++) {
            tt[i] = in.next();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (char a : ss[i].toCharArray()) {
                for (char b : tt[i].toCharArray()) {
                    if (a == b) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt == ss[i].length()) {
                ans += tt[i].length() > ss[i].length() ? 1 : 3;
            }
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
