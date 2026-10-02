package day_23.BOJ_2580;

import java.io.*;
import java.util.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    private static final int[][] map = new int[9][9];
    private static final int[][][] visited = new int[9][9][1 + 9];
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) continue;

                for (int k = 0; k < 9; k++) {
                    // 같은 행 방문체크
                    visited[k][j][map[i][j]]++;

                    // 같은 열 방문체크
                    visited[i][k][map[i][j]]++;

                    // 같은 정사각형 방문체크
                    visited[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3][map[i][j]]++;
                }
            }
        }

        dfs(0, 0);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int r, int c) {
        // 한번만 발견하면 계속 재귀 종료
        if (flag) return;

        // 종료 조건
        if (r == 9) {
            flag = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        // 0이 아닌 칸은 넘어감
        if (map[r][c] != 0) {
            if (c == 8) dfs(r + 1, 0);
            else dfs(r, c + 1);
            return;
        }

        // 0인 칸은 방문해보고 아니면 방문 취소
        for (int i = 1; i <= 9; i++) {
            if (visited[r][c][i] > 0) continue;

            map[r][c] = i;
            for (int k = 0; k < 9; k++) {
                visited[k][c][map[r][c]]++;
                visited[r][k][map[r][c]]++;
                visited[r / 3 * 3 + k / 3][c / 3 * 3 + k % 3][map[r][c]]++;
            }

            if (c == 8) dfs(r + 1, 0);
            else dfs(r, c + 1);

            for (int k = 0; k < 9; k++) {
                visited[k][c][map[r][c]]--;
                visited[r][k][map[r][c]]--;
                visited[r / 3 * 3 + k / 3][c / 3 * 3 + k % 3][map[r][c]]--;
            }
            map[r][c] = 0;
        }
    }

}
