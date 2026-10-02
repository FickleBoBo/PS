package day_13.SWEA_1984;

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

            int[] arr = new int[10];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int sum = 0;
            for (int i = 1; i < 9; i++) {
                sum += arr[i];
            }

            sb.append("#").append(tc).append(" ").append(Math.round(sum / 8.0)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
