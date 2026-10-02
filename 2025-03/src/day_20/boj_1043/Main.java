package day_20.BOJ_1043;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] p;

    private static int[] make(int N) {
        int[] arr = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    private static void union(int x, int y) {
        if (find(x) < find(y)) p[find(y)] = find(x);
        else p[find(x)] = find(y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = make(N);

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        while (st.hasMoreTokens()) {
            p[Integer.parseInt(st.nextToken())] = 0;
        }

        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            while (st.hasMoreTokens()) {
                pq.add(Integer.parseInt(st.nextToken()));
            }

            int x = pq.remove();
            q.add(x);

            while (!pq.isEmpty()) {
                union(x, pq.remove());
            }
        }

        while (!q.isEmpty()) {
            int x = q.remove();

            if (find(x) != 0) cnt++;
        }

        System.out.println(cnt);
    }
}
