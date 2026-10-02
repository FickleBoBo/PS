package day_15.BOJ_1354;

import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Long, Long> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        System.out.println(recur(N, P, Q, X, Y));
    }

    private static long recur(long N, int P, int Q, int X, int Y) {
        if (N <= 0) return 1;
        if (dp.containsKey(N)) return dp.get(N);

        dp.put(N, recur(N / P - X, P, Q, X, Y) + recur(N / Q - Y, P, Q, X, Y));
        return dp.get(N);
    }

}
