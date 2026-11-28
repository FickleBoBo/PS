package day_24.boj_5355;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());

            while (st.hasMoreTokens()) {
                char op = st.nextToken().charAt(0);
                if (op == '@') {
                    x *= 3;
                } else if (op == '%') {
                    x += 5;
                } else {
                    x -= 7;
                }
            }

            System.out.printf("%.2f\n", x);
        }
    }
}
