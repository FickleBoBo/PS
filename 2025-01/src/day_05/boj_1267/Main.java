package day_05.BOJ_1267;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int sumY = 0;
        int sumM = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreElements()) {
            int n = Integer.parseInt(st.nextToken());
            sumY += (n / 30 + 1) * 10;
            sumM += (n / 60 + 1) * 15;
        }

        if (sumY < sumM) sb.append("Y ").append(sumY);
        else if (sumY > sumM) sb.append("M ").append(sumM);
        else sb.append("Y M ").append(sumY);

        bw.write(sb.toString());
        bw.flush();
    }
}
