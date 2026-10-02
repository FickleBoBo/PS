package day_14.BOJ_10867;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[MAX + 1 + MAX];
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            visited[MAX + Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) sb.append(i - MAX).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
