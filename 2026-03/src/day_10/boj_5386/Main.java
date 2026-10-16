package day_10.boj_5386;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (k % 2 != 0) {
                sb.append(s % 2).append("\n");
            } else {
                if (s % (k + 1) == k) {
                    sb.append(k).append("\n");
                } else {
                    sb.append(s % (k + 1) % 2).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
