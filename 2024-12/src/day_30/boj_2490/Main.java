package day_30.BOJ_2490;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 0) cnt++;
            }

            if (cnt == 4) System.out.println("D");
            else if (cnt == 3) System.out.println("C");
            else if (cnt == 2) System.out.println("B");
            else if (cnt == 1) System.out.println("A");
            else if (cnt == 0) System.out.println("E");
        }
    }
}
