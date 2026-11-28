package day_28.boj_2566;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int r = 0, c = 0;

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x > max) {
                    max = x;
                    r = i;
                    c = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(r + " " + c);
    }
}
