package day_10.BOJ_10807;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());

            if (n == v) cnt++;
        }

        System.out.println(cnt);
    }
}
