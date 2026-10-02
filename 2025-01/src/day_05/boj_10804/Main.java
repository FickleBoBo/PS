package day_05.BOJ_10804;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] arr = new int[1 + 20];
        for (int i = 1; i <= 20; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            swap(arr, a, b);
        }

        for (int i = 1; i <= 20; i++) {
            sb.append(arr[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void swap(int[] arr, int a, int b) {
        for (int i = a; i <= (a + b) / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[a + b - i];
            arr[a + b - i] = tmp;
        }
    }

}
