package hackerrank.challenges;

import java.util.*;
import java.io.*;

//test
//7
//1 2 b
//2 3 r
//3 4 r
//4 5 b
//5 6 r
//6 7 b
//20

//5
//1 2 b
//2 3 b
//3 4 r
//4 5 r
//3

//4
//1 2 r
//2 3 r
//3 4 r
//4

//8
//1 2 b
//2 3 b
//3 4 r
//4 5 b
//5 6 b
//6 7 b
//7 8 r
//12
//
//10
//1 2 r
//2 3 b
//3 4 b
//4 5 b
//5 6 b
//6 7 r
//7 8 r
//8 9 r
//9 10 r
//60

public class KunduAndTreeSolution {
    static List<Integer>[] tree = null;
    static int[] group = null;
    static boolean[] visited = null;
    static long P = 1000000007;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);

        int n = in.nextInt();

        if (n < 3) {
            System.out.println(0);
            return;
        }

        tree = new List[n];
        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < n-1; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            String color = in.nextString();
            if (color.equals("b")) {
                tree[from].add(to);
                tree[to].add(from);
            }
        }

        Arrays.stream(tree).forEach(System.out::println);

        group = new int[n];
        visited = new boolean[n];
        int gid = 0;
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                checkGroup(i, gid);
                gid++;
            }
        }

        Arrays.stream(group).forEach(System.out::println);

        //for(int i = 0; i < gid; i++)
        //    System.out.println(i + " : " + group[i]);

        long[] C = new long[n+1];
        C[3] = 1;
        for(int i = 4; i <= n; i++) {
            C[i] = (C[i-1] * i) % P;
            C[i] = (C[i] * calInverse(i-3, P-2)) % P;
        }

        //for(int i = 0; i <= n; i++)
        //    System.out.println(i + " : " + C[i]);

        long out = C[n];
        for(int i = 0; i < gid; i++) {
            long x = group[i];
            long g = (x * (x - 1) / 2 * (n-x)) % P;
            g = (g + C[group[i]]) % P;
            out += P - g;
            if (out >= P)
                out -= P;
        }
        System.out.println(out);
    }

    static long calInverse(long x, long p) {
        long ret = 1;
        long base = x;
        while(p > 0) {
            if ((p & 1) == 1) {
                ret = (ret * base) % P;
            }
            base = (base * base) % P;
            p >>= 1;
        }
        return ret;
    }

    static void checkGroup(int from, int gid) {
        visited[from] = true;
        group[gid]++;
        for(int next : tree[from]) {
            if (!visited[next]) {
                checkGroup(next, gid);
            }
        }
    }

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder sb = new StringBuilder(1024);
            do {
                sb.append((char)c);
                c = read();
            } while (!isSpaceChar(c));
            return sb.toString();
        }

        public static boolean isSpaceChar(int c) {
            switch (c) {
                case -1:
                case ' ':
                case '\n':
                case '\r':
                case '\t':
                    return true;
                default:
                    return false;
            }
        }
    }
}
