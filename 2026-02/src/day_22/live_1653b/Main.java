package day_22.monthly_b;

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
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long u = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            long ht = (u + d == 0) ? 0 : (n - 1 + u + d - 1) / (u + d);
            long wt = (l + r == 0) ? 0 : (m - 1 + l + r - 1) / (l + r);

            long fill = 1;
            if (ht != 0) fill *= n;
            if (wt != 0) fill *= m;

            sb.append(fill).append(" ").append(ht + wt).append("\n");
        }

        System.out.println(sb);
    }
}
