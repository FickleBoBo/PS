package day_25.boj_9085;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (n-- > 0) {
                sum += Integer.parseInt(st.nextToken());
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}
