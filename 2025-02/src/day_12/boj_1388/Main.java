package day_12.BOJ_1388;

import java.io.*;
import java.util.*;

public class Main {

    private static final char EMPTY = '\u0000';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == EMPTY) continue;

                if (map[i][j] == '-') {
                    int k = 0;
                    while (j + k < M && map[i][j + k] == '-') {
                        map[i][j + k] = EMPTY;
                        k++;
                    }
                } else if (map[i][j] == '|') {
                    int k = 0;
                    while (i + k < N && map[i + k][j] == '|') {
                        map[i + k][j] = EMPTY;
                        k++;
                    }
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
