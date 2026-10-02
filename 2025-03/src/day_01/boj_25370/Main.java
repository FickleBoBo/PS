package day_01.BOJ_25370;

import java.io.*;
import java.util.*;

public class Main {

    private static final Set<Integer> set = new HashSet<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        permutation(0, 1);

        System.out.println(set.size());
    }

    private static void permutation(int selIdx, int result) {
        if (selIdx == N) {
            set.add(result);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            permutation(selIdx + 1, result * i);
        }
    }

}
