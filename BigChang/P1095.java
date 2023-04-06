package BigChang;

import java.io.*;
import java.util.StringTokenizer;

public class P1095{


//    米哈游春招后端-2023.03.19-第二题-米哈游子序列

    static void solve(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int[] scnt = new int[3];
        int[] tcnt = new int[3];
        for (char c : s.toCharArray()) {
            if (c == 'm') scnt[0]++;
            else if (c == 'h') scnt[1]++;
            else if (c == 'y') scnt[2]++;
            else sb1.append(c);
        }
        for (char c : t.toCharArray()) {
            if (c == 'm') tcnt[0]++;
            else if (c == 'h') tcnt[1]++;
            else if (c == 'y') tcnt[2]++;
            else sb2.append(c);
        }
        if (!sb1.toString().equals(sb2.toString())) {
            out.println("No");
            return;
        }
        int a = scnt[0] - tcnt[0];
        int b = scnt[1] - tcnt[1];
        int c = scnt[2] - tcnt[2];
        if (a == b && b == c) {
            out.println("Yes");
        } else {
            out.println("No");
        }
    }

    public static void main(String[] args) throws IOException {
        int q = in.nextInt();
        while (q-- > 0) {
            String s = in.next();
            String t = in.next();
            solve(s, t);
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