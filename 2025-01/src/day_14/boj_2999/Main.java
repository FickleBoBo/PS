package day_14.BOJ_2999;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        int len = input.length;

        int R = 0;
        int C = 0;
        for (int i = 1; i * i <= len; i++) {
            if ((len % i) == 0) {
                R = i;
                C = len / i;
            }
        }

        char[][] map = new char[R][C];

        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                map[i][j] = input[j * R + i];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
