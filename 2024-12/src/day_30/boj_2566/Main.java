package day_30.BOJ_2566;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int max = -1;
        int row = 0;
        int col = 0;
        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 9; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num > max) {
                    max = num;
                    row = i;
                    col = j;
                }
            }
        }

        sb.append(max).append("\n").append(row).append(" ").append(col);

        bw.write(sb.toString());
        bw.flush();
    }
}
