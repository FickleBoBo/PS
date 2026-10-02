package day_08.BOJ_11728;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> A = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            A.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> B = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            B.offer(Integer.parseInt(st.nextToken()));
        }

        while (!(A.isEmpty() && B.isEmpty())) {
            if (A.isEmpty()) sb.append(B.poll()).append(" ");
            else if (B.isEmpty()) sb.append(A.poll()).append(" ");
            else sb.append(A.peek() < B.peek() ? A.poll() : B.poll()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
