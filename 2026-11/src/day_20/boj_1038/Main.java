package day_20.boj_1038;

import java.io.*;
import java.util.*;

public class Main {

    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= 9; i++) {
            dfs(i);
        }

        if (n >= list.size()) {
            System.out.println(-1);
            return;
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(n));
    }

    static void dfs(long cur) {
        list.add(cur);
        for (int i = 0; i < cur % 10; i++) {
            dfs(cur * 10 + i);
        }
    }
}
