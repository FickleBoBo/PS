package day_15.BOJ_10984;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int grade = 0;
            double GPA = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());
                double G = Double.parseDouble(st.nextToken());

                grade += C;
                GPA += C * G;
            }

            sb.append(grade).append(" ").append(Math.round(GPA / grade * 10) / 10.0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
