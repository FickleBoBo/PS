package day_10.BOJ_10808;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] S = br.readLine().toCharArray();

        int[] cntArr = new int[26];

        for (char c : S) {
            cntArr[c - 'a']++;
        }

        for (int cnt : cntArr) {
            sb.append(cnt).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
