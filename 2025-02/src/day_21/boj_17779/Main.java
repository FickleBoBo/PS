package day_21.BOJ_17779;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {

                    // 경계선이 넘어가지 않게 조건 체크
                    if (x + d1 >= N) continue;
                    if (y - d1 < 0) continue;

                    for (int d2 = 1; d2 < N; d2++) {

                        // 경계선이 넘어가지 않게 조건 체크
                        if (x + d2 >= N) continue;
                        if (y + d2 >= N) continue;

                        // 경계선이 넘어가지 않게 조건 체크
                        if (x + d1 + d2 >= N) continue;

                        // 경계선 마킹 배열
                        int[][] mark = new int[N][N];
                        for (int d = 0; d <= d1; d++) {
                            mark[x + d][y - d] = 5;
                            mark[x + d2 + d][y + d2 - d] = 5;
                        }
                        for (int d = 0; d <= d2; d++) {
                            mark[x + d][y + d] = 5;
                            mark[x + d1 + d][y - d1 + d] = 5;
                        }

                        int area1 = 0;
                        for (int i = 0; i < x + d1; i++) {
                            for (int j = 0; j <= y; j++) {
                                if (mark[i][j] == 5) break;
                                area1 += map[i][j];
                            }
                        }
                        if (area1 == 0) continue;

                        int area2 = 0;
                        for (int j = N - 1; j > y; j--) {
                            for (int i = 0; i <= x + d2; i++) {
                                if (mark[i][j] == 5) break;
                                area2 += map[i][j];
                            }
                        }
                        if (area2 == 0) continue;

                        int area3 = 0;
                        for (int j = 0; j < y - d1 + d2; j++) {
                            for (int i = N - 1; i >= x + d1; i--) {
                                if (mark[i][j] == 5) break;
                                area3 += map[i][j];
                            }
                        }
                        if (area3 == 0) continue;

                        int area4 = 0;
                        for (int i = N - 1; i > x + d2; i--) {
                            for (int j = N - 1; j >= y - d1 + d2; j--) {
                                if (mark[i][j] == 5) break;
                                area4 += map[i][j];
                            }
                        }
                        if (area4 == 0) continue;

                        int area5 = sum - area1 - area2 - area3 - area4;

                        int max = Math.max(area1, Math.max(area2, Math.max(area3, Math.max(area4, area5))));
                        int min = Math.min(area1, Math.min(area2, Math.min(area3, Math.min(area4, area5))));

                        ans = Math.min(ans, max - min);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
