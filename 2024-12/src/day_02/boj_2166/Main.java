package day_02.BOJ_2166;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 좌표의 곱이 int형 오버플로우가 발생할 수 있음
        long[][] points = new long[1 + N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        points[N][0] = points[0][0];
        points[N][1] = points[0][1];

        double area = 0;

        // 신발끈 공식
        for (int i = 0; i < N; i++) {
            area += points[i][0] * points[i + 1][1] - points[i][1] * points[i + 1][0];
        }

        System.out.printf("%.1f", Math.abs(area / 2));
    }
}
