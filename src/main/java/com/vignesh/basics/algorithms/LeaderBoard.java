package com.vignesh.basics.algorithms;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by aurel on 16.10.2016.
 */
public class LeaderBoard {

    public static void main(String[] args) {
        InputReader in = new StreamInputReader(System.in, 2048);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out, 2048), false);

        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();
//        long prev = -1;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
//            if (x != prev) {
                a.add(x);
//            }
//            prev = x;
        }

        Comparator<Long> cmp = new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        };
        List<Integer> b = new ArrayList<>();
        int m = in.nextInt();
        while (m-- > 0) {
            int x = in.nextInt();
            b.add(x);
//            int j = Collections.binarySearch(a, x, cmp);
//            if (j < 0) {
//                j = -j - 1;
//            }
//            out.println(j + 1);
        }
        List<Integer> result = climbingLeaderboard(a, b);
        result.forEach(out::println);
        out.close();
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> playerPosition = new ArrayList<>();
        List<Integer> leaderBoard = new ArrayList<>();
        Integer prev = -1;
        for(Integer val:ranked) {
            if(!val.equals(prev)) {
                leaderBoard.add(val);
            }
            prev = val;
        }
        //System.out.println("distinct : "+leaderBoard.size());
        Comparator<Integer> comp = (a,b) -> b.compareTo(a);
        for(Integer points:player) {
            int pos = Collections.binarySearch(leaderBoard,points,comp);
            if(pos < 0) {
                pos = -pos-1;
            }
            playerPosition.add(pos+1);
        }
        return playerPosition;
    }

    abstract static class InputReader {

        public abstract int read();

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class StreamInputReader extends InputReader {

        private InputStream stream;
        private byte[] buf;
        private int curChar, numChars;

        public StreamInputReader(InputStream stream) {
            this(stream, 2048);
        }

        public StreamInputReader(InputStream stream, int bufSize) {
            this.stream = stream;
            this.buf = new byte[bufSize];
        }

        @Override
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
    }

}
