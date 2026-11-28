package day_27.boj_5397;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Deque<Character> f = new ArrayDeque<>();
            Deque<Character> b = new ArrayDeque<>();

            String s = br.readLine();
            for (char c : s.toCharArray()) {
                if (c == '-') {
                    if (!f.isEmpty()) f.pollLast();
                } else if (c == '<') {
                    if (!f.isEmpty()) b.offerFirst(f.pollLast());
                } else if (c == '>') {
                    if (!b.isEmpty()) f.offerLast(b.pollFirst());
                } else {
                    f.offerLast(c);
                }
            }

            for (char c : f) {
                sb.append(c);
            }
            for (char c : b) {
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
