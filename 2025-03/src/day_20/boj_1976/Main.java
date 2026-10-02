package day_20.BOJ_1976;

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
        p[find(y)] = find(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        p = make(N);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int bit = Integer.parseInt(st.nextToken());

                if (bit == 1) union(i, j);
            }
        }

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            set.add(find(Integer.parseInt(st.nextToken())));
        }

        if (set.size() == 1) System.out.println("YES");
        else System.out.println("NO");
    }
}
