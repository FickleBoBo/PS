package day_13.BOJ_2477;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[6];
        int max = 0;
        int maxIdx = -1;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            int num = Integer.parseInt(st.nextToken());
            if (num > max) {
                max = num;
                maxIdx = i;
            }

            arr[i] = num;
        }

        if (arr[(maxIdx - 1 + 6) % 6] < arr[(maxIdx + 1 + 6) % 6]) {
            int large = arr[maxIdx] * arr[(maxIdx + 1 + 6) % 6];
            int small = arr[(maxIdx + 3 + 6) % 6] * arr[(maxIdx + 4 + 6) % 6];
            System.out.println(K * (large - small));
        } else {
            int large = arr[maxIdx] * arr[(maxIdx - 1 + 6) % 6];
            int small = arr[(maxIdx - 3 + 6) % 6] * arr[(maxIdx - 4 + 6) % 6];
            System.out.println(K * (large - small));
        }
    }
}
