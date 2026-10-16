package day_24.boj_35307;

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

            long ht = (u + d != 0) ? (n - 1 + u + d - 1) / (u + d) : 0;
            long wt = (l + r != 0) ? (m - 1 + l + r - 1) / (l + r) : 0;

            long cnt = 1;
            if (ht != 0) cnt *= n;
            if (wt != 0) cnt *= m;

            sb.append(cnt).append(" ").append(ht + wt).append("\n");
        }

        System.out.println(sb);
    }
}
