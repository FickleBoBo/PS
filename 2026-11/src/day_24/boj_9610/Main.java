package day_24.boj_9610;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[5];

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) {
                cnt[0]++;
                continue;
            }

            if (x > 0) {
                if (y > 0) {
                    cnt[1]++;
                } else {
                    cnt[4]++;
                }
            } else {
                if (y > 0) {
                    cnt[2]++;
                } else {
                    cnt[3]++;
                }
            }
        }

        System.out.println("Q1: " + cnt[1]);
        System.out.println("Q2: " + cnt[2]);
        System.out.println("Q3: " + cnt[3]);
        System.out.println("Q4: " + cnt[4]);
        System.out.println("AXIS: " + cnt[0]);
    }
}
