package day_22.boj_11328;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] cnt = new int[26];
            for (char c : st.nextToken().toCharArray()) {
                cnt[c - 'a']++;
            }
            for (char c : st.nextToken().toCharArray()) {
                cnt[c - 'a']--;
            }

            boolean flag = true;
            for (int x : cnt) {
                if (x != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                bw.write("Possible\n");
            } else {
                bw.write("Impossible\n");
            }
        }

        bw.flush();
    }
}
