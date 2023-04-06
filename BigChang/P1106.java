package BigChang;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1106 {

//    腾讯音乐-2023.3.23-第二题-划分字符串

    static void solve(String s, int k) {
        long l = 1;
        long r = 500001 * 26L;
        while (l < r) {
            long mid = l + r >> 1;
            if (check(s, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        out.print(l);
    }


    static boolean check(String s, int k, long mid) {
        int[] mp = new int[26];
        long cnt = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (++mp[c-'a'] == 1) cnt++;
            len++;
            if (len * cnt > mid) {
                k--;
                Arrays.fill(mp, 0);
                cnt = 1;
                len = 1;
                mp[c-'a'] = 1;
            }
        }
        return k - 1 >= 0;
    }


    public static void main(String[] args) throws IOException {
        String s = in.next();
        int k = in.nextInt();
        solve(s, k);
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
