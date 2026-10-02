package day_12.SWEA_1954;

import java.io.*;

public class Solution {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(Solution.class.getResourceAsStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            int r = 0;
            int c = 0;
            int d = 0;
            int num = 1;

            while (num <= N * N) {
                map[r][c] = num;

                if ((r + dr[d] < 0) || (r + dr[d] >= N) || (c + dc[d] < 0) || (c + dc[d] >= N)) d++;
                else if (map[r + dr[d]][c + dc[d]] != 0) d++;

                d %= 4;
                r += dr[d];
                c += dc[d];
                num++;
            }

            sb.append("#").append(tc).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
