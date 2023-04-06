package BigChang;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1007 {

//     2022.11.5-找出符合条件的子字符串

    static void solve(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        int ans = 1;
        while (i < n) {
            char v = s.charAt(i);
            mp.merge(v, 1, Integer::sum);
            while (j < n && mp.get(v) > 1) {
                char x = s.charAt(j);
                mp.put(x, mp.get(x) - 1);
                j++;
            }
            ans = Math.max(ans, i - j + 1);
            i++;
        }
        out.print(ans);
    }

    public static void main(String[] args) throws IOException {
        String s = in.next();
        solve(s);
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
