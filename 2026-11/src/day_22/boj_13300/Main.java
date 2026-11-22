package day_22.boj_13300;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] cnt = new int[1 + 6][2];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cnt[y][s]++;
        }

        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j <= 1; j++) {
                ans += (cnt[i][j] + k - 1) / k;
            }
        }

        System.out.println(ans);
    }
}
