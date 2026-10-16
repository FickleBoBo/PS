package day_06.boj_7977;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }

        int min = Math.min(Math.min(cnt[0], cnt[2]), Math.min(cnt[6], cnt[19]));

        System.out.println(min);
        System.out.println(getDna(n, cnt, min));
    }

    static String getDna(int n, int[] cnt, int min) {
        if (cnt[0] == min) return "A".repeat(n);
        if (cnt[2] == min) return "C".repeat(n);
        if (cnt[6] == min) return "G".repeat(n);
        return "T".repeat(n);
    }
}
