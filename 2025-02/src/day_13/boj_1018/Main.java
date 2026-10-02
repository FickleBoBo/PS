package day_13.BOJ_1018;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cnt1 = 0;  // 맨 왼쪽 위 칸이 검은색인 체스판을 만드는 경우
                int cnt2 = 0;  // 맨 왼쪽 위 칸이 흰색인 체스판을 만드는 경우

                for (int a = i; a < i + 8; a++) {
                    for (int b = j; b < j + 8; b++) {
                        if ((a - i + b - j) % 2 == 0) {
                            if (map[a][b] == 'B') cnt2++;
                            else cnt1++;
                        } else {
                            if (map[a][b] == 'B') cnt1++;
                            else cnt2++;
                        }
                    }
                }

                min = Math.min(min, Math.min(cnt1, cnt2));
            }
        }

        System.out.println(min);
    }
}
