package day_13.SWEA_2068;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(Solution.class.getResourceAsStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int max = 0;

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                max = Math.max(max, Integer.parseInt(st.nextToken()));
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
