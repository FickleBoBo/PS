package day_01.BOJ_9610;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x > 0) {
                if (y > 0) arr[1]++;
                else if (y < 0) arr[4]++;
                else arr[0]++;
            } else if (x < 0) {
                if (y > 0) arr[2]++;
                else if (y < 0) arr[3]++;
                else arr[0]++;
            } else {
                arr[0]++;
            }
        }

        sb
                .append("Q1: ").append(arr[1]).append("\n")
                .append("Q2: ").append(arr[2]).append("\n")
                .append("Q3: ").append(arr[3]).append("\n")
                .append("Q4: ").append(arr[4]).append("\n")
                .append("AXIS: ").append(arr[0]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}
