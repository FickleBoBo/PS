package day_25.BOJ_25426;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[][] coefficients = new long[1 + N][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            coefficients[i][0] = Long.parseLong(st.nextToken());
            coefficients[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(coefficients, ((o1, o2) -> Long.compare(o1[0], o2[0])));

        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += coefficients[i][0] * i + coefficients[i][1];
        }

        System.out.println(sum);
    }
}
