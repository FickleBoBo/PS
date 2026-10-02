package day_06.BOJ_1371;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
            }
        }

        input = sb.toString();
        int[] cntArr = new int[26];
        for (int i = 0; i < input.length(); i++) {
            cntArr[input.charAt(i) - 'a']++;
        }

        int max = 0;
        for (int cnt : cntArr) {
            max = Math.max(max, cnt);
        }

        sb = new StringBuilder();
        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] == max) {
                sb.append((char) (i + 'a'));
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
