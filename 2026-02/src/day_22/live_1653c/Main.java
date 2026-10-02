package day_22.monthly_c;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 1 && k == 1) {
                sb.append("1\n");
            } else if (k != 2) {
                sb.append("-1\n");
            } else {
                for (int i = 2; i <= n; i++) {
                    sb.append(i).append(" ");
                }
                sb.append("1\n");
            }
        }

        System.out.println(sb);
    }
}
