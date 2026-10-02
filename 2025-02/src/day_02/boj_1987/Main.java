package day_02.BOJ_1987;

import java.io.*;
import java.util.*;

public class Main_DFS {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static int R;
    private static int C;
    private static char[][] map;
    private static final Set<Character> set = new HashSet<>();
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int r, int c) {
        set.add(map[r][c]);
        max = Math.max(max, set.size());

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (set.contains(map[nr][nc])) continue;

            dfs(nr, nc);

            set.remove(map[nr][nc]);
        }
    }

}
