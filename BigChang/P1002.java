package BigChang;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1002 {

//    P1002. 塔子哥の插队

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        var pq = new PriorityQueue<int[]>((a, b) -> {
            if (a[1] == b[1]) return a[2] - b[2];
            return a[1] - b[1];
        });
        int v = 1; // 到达的顺序
        while (n-- > 0) {
            String s = in.next();
            if (s.equals("a")) {
                int num = in.nextInt();
                int x = in.nextInt();
                pq.offer(new int[]{num, x, v});
                ++v;
            } else {
                int[] p = pq.poll();
                out.println(p[0]);
            }
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
