package day_22.boj_1292;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[1 + 1000];
        int num = 1;
        int idx = 1;

        out:
        while (true) {
            for (int i = 1; i <= num; i++) {
                arr[idx++] = num;
                if (idx > 1000) break out;
            }
            num++;
        }

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
