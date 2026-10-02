package day_07.BOJ_2960;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[1 + N];
        int order = 0;

        out:
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (visited[j]) continue;

                visited[j] = true;
                order++;
                if (order == K) {
                    System.out.println(j);
                    break out;
                }
            }
        }
    }
}
