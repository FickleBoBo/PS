package day_22.cofo_2148a;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (n % 2 == 1) {
                System.out.println(x);
            } else {
                System.out.println(0);
            }
        }
    }
}
