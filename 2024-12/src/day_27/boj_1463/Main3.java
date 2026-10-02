package day_27.BOJ_1463;

import java.io.*;
import java.util.*;

public class Main_DP2 {

    private static final Map<Integer, Integer> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp.put(1, 0);

        System.out.println(recur(N));
    }

    private static int recur(int N) {
        if (dp.containsKey(N)) return dp.get(N);

        if (N % 6 == 0) dp.put(N, Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1);
        else if (N % 3 == 0) dp.put(N, Math.min(recur(N / 3), recur(N - 1)) + 1);
        else if (N % 2 == 0) dp.put(N, Math.min(recur(N / 2), recur(N - 1)) + 1);
        else dp.put(N, recur(N - 1) + 1);

        return dp.get(N);
    }

}
