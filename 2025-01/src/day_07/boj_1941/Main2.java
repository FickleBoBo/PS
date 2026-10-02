package day_07.BOJ_1941;

import java.io.*;
import java.util.*;

public class Main_Bitmask {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            sb.append(br.readLine());
        }
        char[] map = sb.toString().toCharArray();
        int ans = 0;

        List<Integer> combinations = combination(25, 7);
        for (int combination : combinations) {
            if (check(map, combination) && bfs(combination, Integer.numberOfTrailingZeros(combination))) ans++;
        }

        System.out.println(ans);
    }

    // 칠공주에 뽑힌 사람에 해당하는 비트를 1로 표현
    private static List<Integer> combination(int n, int r) {
        List<Integer> result = new ArrayList<>();

        int bitmask = (1 << r) - 1;

        while (bitmask < (1 << n)) {
            result.add(bitmask);

            int x = bitmask & -bitmask;
            int y = bitmask + x;
            bitmask = ((bitmask & ~y) / x >> 1) | y;
        }

        return result;
    }

    // 7명 중 이다솜파가 더 많으면 true
    private static boolean check(char[] map, int combination) {
        int cnt = 0;
        for (int i = 0; i < 25; i++) {
            if ((combination & (1 << i)) != 0)
                if (map[i] == 'S') cnt++;
        }
        return cnt > 3;
    }

    // 7명이 가로세로로 인접해있으면 true
    private static boolean bfs(int combination, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        int visited = 0;
        visited |= (1 << start);

        int cnt = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = node / 5 + dr[dir];
                int nc = node % 5 + dc[dir];
                int next = nr * 5 + nc;

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                if ((visited & (1 << next)) != 0) continue;
                if ((combination & (1 << next)) == 0) continue;

                q.offer(next);
                visited |= (1 << next);
                cnt++;
            }
        }

        return cnt == 7;
    }

}
