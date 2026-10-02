package day_14.BOJ_6996;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        out:
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            char[] str1 = st.nextToken().toCharArray();
            char[] str2 = st.nextToken().toCharArray();

            int[] cntArr = new int[26];
            for (char c : str1) {
                cntArr[c - 'a']++;
            }
            for (char c : str2) {
                cntArr[c - 'a']--;
            }

            for (int cnt : cntArr) {
                if (cnt != 0) {
                    sb.append(str1).append(" & ").append(str2).append(" are NOT anagrams.\n");
                    continue out;
                }
            }

            sb.append(str1).append(" & ").append(str2).append(" are anagrams.\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
