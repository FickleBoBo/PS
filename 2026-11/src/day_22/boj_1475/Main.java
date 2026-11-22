package day_22.boj_1475;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[10];
        for (char c : br.readLine().toCharArray()) {
            cnt[c - '0']++;
        }

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            max = Math.max(max, cnt[i]);
        }
        max = Math.max(max, (cnt[6] + cnt[9] + 1) / 2);

        System.out.println(max);
    }
}
