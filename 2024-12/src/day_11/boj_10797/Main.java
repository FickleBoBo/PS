package day_11.BOJ_10797;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int day = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int cnt = 0;

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());

            if (day == n) cnt++;
        }

        System.out.println(cnt);
    }
}
