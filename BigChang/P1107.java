package BigChang;

import java.io.*;
import java.util.StringTokenizer;

public class P1107 {


//    腾讯音乐-2023.3.23-第三题-小红的签到题

    public static void main(String[] args) throws IOException {
        String s = in.next();
        s = s.toLowerCase();
        int ans = 0;
        for (int i = 0, j = -1; i < s.length(); i++, j++) {
            if (j == -1) continue;
            if (s.charAt(i) == s.charAt(j)) ans++;
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
