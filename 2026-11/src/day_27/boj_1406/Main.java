package day_27.boj_1406;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Character> f = new ArrayDeque<>();
        Deque<Character> b = new ArrayDeque<>();

        String s = br.readLine();
        for (char c : s.toCharArray()) {
            f.offerLast(c);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);

            if (op == 'L') {
                if (!f.isEmpty()) b.offerFirst(f.pollLast());
            } else if (op == 'D') {
                if (!b.isEmpty()) f.offerLast(b.pollFirst());
            } else if (op == 'B') {
                if (!f.isEmpty()) f.pollLast();
            } else {
                f.offerLast(st.nextToken().charAt(0));
            }
        }

        for (char c : f) {
            sb.append(c);
        }
        for (char c : b) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}
