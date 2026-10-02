package day_22.monthly_a;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[n];

        int[][] map = new int[n][k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            int max = 0;
            int cnt = 0;
            int idx = 0;

            for (int j = 0; j < n; j++) {
                if (map[j][i] > max) {
                    max = map[j][i];
                    cnt = 1;
                    idx = j;
                } else if (map[j][i] == max) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                check[idx] = true;
            }
        }

        int cnt = 0;
        for (boolean flag : check) {
            if (flag) cnt++;
        }

        System.out.println(cnt);
    }
}
