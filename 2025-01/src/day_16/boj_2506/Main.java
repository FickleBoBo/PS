package day_16.BOJ_2506;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int sum = 0;

        int[] arr = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] == 0) continue;
            if (arr[i - 1] != 0) arr[i] = arr[i - 1] + 1;

            sum += arr[i];
        }

        System.out.println(sum);
    }
}
