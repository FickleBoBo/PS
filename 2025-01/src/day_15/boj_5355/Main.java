package day_15.BOJ_5355;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            double N = Double.parseDouble(st.nextToken());

            while (st.hasMoreTokens()) {
                char operator = st.nextToken().charAt(0);

                if (operator == '@') N *= 3;
                else if (operator == '%') N += 5;
                else N -= 7;
            }

            System.out.printf("%.2f\n", N);
        }
    }
}
