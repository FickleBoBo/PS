package day_28.boj_9366;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a >= b + c || b >= a + c || c >= a + b) {
                sb.append("Case #").append(tc).append(": invalid!\n");
            } else if (a == b && b == c) {
                sb.append("Case #").append(tc).append(": equilateral\n");
            } else if (a == b || b == c || c == a) {
                sb.append("Case #").append(tc).append(": isosceles\n");
            } else {
                sb.append("Case #").append(tc).append(": scalene\n");
            }
        }

        System.out.println(sb);
    }
}
