package day_04.BOJ_11328;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        out:
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char[] input = st.nextToken().toCharArray();
            char[] input2 = st.nextToken().toCharArray();

            int[] cntArr = new int[26];
            for (char c : input) {
                cntArr[c - 'a']++;
            }
            for (char c : input2) {
                cntArr[c - 'a']--;
            }

            for (int cnt : cntArr) {
                if (cnt != 0) {
                    bw.write("Impossible\n");
                    continue out;
                }
            }

            bw.write("Possible\n");
        }

        bw.flush();
    }
}
