package day_22.boj_1919;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[26];
        for (char c : br.readLine().toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : br.readLine().toCharArray()) {
            cnt[c - 'a']--;
        }

        int ans = 0;
        for (int x : cnt) {
            ans += Math.abs(x);
        }

        System.out.println(ans);
    }
}
