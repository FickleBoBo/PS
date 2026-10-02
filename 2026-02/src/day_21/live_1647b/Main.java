package day_21.ksa_b;

import java.io.*;
import java.util.*;

// 체감 실2
// 18:40 ~ 19:00
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'X') {
                    if (i < n - 1 && map[i + 1][j] == 'X') {
                        sb.append(2).append(" ").append(i + 1 + n * j).append(" ").append(i + 2 + n * j).append("\n");
                        map[i][j] = 'O';
                        map[i + 1][j] = 'O';
                    } else if (n == 1 && j < m - 1 && map[i][j + 1] == 'X') {
                        sb.append(2).append(" ").append(i + 1 + n * j).append(" ").append(i + 1 + n * (j + 1)).append("\n");
                        map[i][j] = 'O';
                        map[i][j + 1] = 'O';
                    } else {
                        sb.append(1).append(" ").append(i + 1 + n * j).append("\n");
                        map[i][j] = 'O';
                    }
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}
