package BigChang;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1123 {

//     2023.03.26-第二题-重组字符串

    static int N = 10;
    static int ans = 0;
    static String[] a = new String[N];
    static int[] cnt = new int[26];
    static HashSet<String> set = new HashSet<>();
    static StringBuilder path = new StringBuilder();


    static void dfs(int pos, int n) {
        if (pos >= n) {
            if (!set.contains(path.toString())) {
                ans++;
                set.add(path.toString());
            }
            return;
        }
        for (int i = 0; i < a[pos].length(); i++) {
            int v = a[pos].charAt(i) - 'a';
            if (cnt[v] == 0) {
                path.append(a[pos].charAt(i));
                ++cnt[v];
                dfs(pos + 1, n);
                path.deleteCharAt(path.length() - 1);
                --cnt[v];
            }
        }
    }


    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.next();
        }
        dfs(0, n);
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
