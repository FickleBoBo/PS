package day_06.BOJ_5596;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int S = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            S += Integer.parseInt(st.nextToken());
        }

        int T = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            T += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(S, T));
    }
}
