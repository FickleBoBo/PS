package day_23.BOJ_2580;

import java.io.*;
import java.util.*;

public class Main2 {

    private static final StringBuilder sb = new StringBuilder();

    private static final List<int[]> list = new ArrayList<>();

    private static final int[][] map = new int[9][9];
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) list.add(new int[]{i, j});
            }
        }

        permutation(0);

        bw.write(sb.toString());
        bw.flush();
    }

    // 0인 칸들에 대해 1 ~ 9를 배치하는 중복 순열
    private static void permutation(int selIdx) {
        if (flag) return;

        if (selIdx == list.size()) {
            flag = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for (int n = 1; n <= 9; n++) {
            if (!canPlace(list.get(selIdx)[0], list.get(selIdx)[1], n)) continue;

            map[list.get(selIdx)[0]][list.get(selIdx)[1]] = n;
            permutation(selIdx + 1);
            map[list.get(selIdx)[0]][list.get(selIdx)[1]] = 0;
        }
    }

    // 스도쿠에서 배치 가능한 숫자인지 boolean 타입으로 반환
    private static boolean canPlace(int r, int c, int num) {
        boolean canPlace = true;

        for (int k = 0; k < 9; k++) {
            if (map[k][c] == num || map[r][k] == num || map[r / 3 * 3 + k / 3][c / 3 * 3 + k % 3] == num) {
                canPlace = false;
                break;
            }
        }

        return canPlace;
    }

}
