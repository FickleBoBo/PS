package day_12.BOJ_3985;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] before = new int[1 + N];
        int[] after = new int[1 + N];
        int[] cake = new int[1 + L];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            before[i] = end - start + 1;
            for (int j = start; j <= end; j++) {
                if (cake[j] == 0) {
                    cake[j] = i;
                    after[i]++;
                }
            }
        }

        int max1 = 0;
        int ans1 = 0;
        int max2 = 0;
        int ans2 = 0;
        for (int i = 1; i <= N; i++) {
            if (before[i] > max1) {
                max1 = before[i];
                ans1 = i;
            }
            if (after[i] > max2) {
                max2 = after[i];
                ans2 = i;
            }
        }

        System.out.println(ans1);
        System.out.println(ans2);
    }
}
