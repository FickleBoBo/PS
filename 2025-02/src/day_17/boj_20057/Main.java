package day_17.BOJ_20057;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {-1, 0, 1, 0};

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

        int r = N / 2;
        int c = N / 2;
        int d = 0;

        int len = 1;
        int check = 0;
        int cnt = 0;

        while (true) {
            r += dr[d];
            c += dc[d];
            if (c < 0) break;

            spread(r, c, d, N, map);
            cnt++;

            if (len == cnt) {
                d = (d + 1) % 4;
                check++;
                cnt = 0;
            }

            if (check == 2) {
                len++;
                check = 0;
            }
        }

        int exist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                exist += map[i][j];
            }
        }

        System.out.println(sum - exist);
    }

    private static void spread(int r, int c, int d, int N, int[][] map) {
        int[][] matrix = getMatrix(map[r][c], d);

        for (int i = r - 2; i <= r + 2; i++) {
            for (int j = c - 2; j <= c + 2; j++) {
                if (i < 0 || i >= N || j < 0 || j >= N) continue;

                map[i][j] += matrix[i - r + 2][j - c + 2];
            }
        }

        map[r][c] = 0;
    }

    private static int[][] getMatrix(int sand, int d) {
        int one = sand / 100;
        int two = sand / 50;
        int five = sand / 20;
        int seven = sand * 7 / 100;
        int ten = sand / 10;
        int remain = sand - 2 * one - 2 * two - 2 * seven - 2 * ten - five;

        if (d == 0) return new int[][]{
                {0, 0, two, 0, 0},
                {0, ten, seven, one, 0},
                {five, remain, 0, 0, 0},
                {0, ten, seven, one, 0},
                {0, 0, two, 0, 0},
        };
        if (d == 1) return new int[][]{
                {0, 0, 0, 0, 0},
                {0, one, 0, one, 0},
                {two, seven, 0, seven, two},
                {0, ten, remain, ten, 0},
                {0, 0, five, 0, 0},
        };
        if (d == 2) return new int[][]{
                {0, 0, two, 0, 0},
                {0, one, seven, ten, 0},
                {0, 0, 0, remain, five},
                {0, one, seven, ten, 0},
                {0, 0, two, 0, 0},
        };
        return new int[][]{
                {0, 0, five, 0, 0},
                {0, ten, remain, ten, 0},
                {two, seven, 0, seven, two},
                {0, one, 0, one, 0},
                {0, 0, 0, 0, 0},
        };
    }

}
