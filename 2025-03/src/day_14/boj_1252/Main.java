package day_14.BOJ_1252;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        int len = Math.max(A.length, B.length);
        int[] arr = new int[1 + len];

        for (int i = 0; i < A.length; i++) {
            arr[i - A.length + len + 1] += A[i] - '0';
        }
        for (int i = 0; i < B.length; i++) {
            arr[i - B.length + len + 1] += B[i] - '0';
        }

        for (int i = len; i >= 1; i--) {
            if (arr[i] >= 2) {
                arr[i] -= 2;
                arr[i - 1]++;
            }
        }

        boolean flag = false;
        for (int i = 0; i <= len; i++) {
            if (arr[i] == 1) flag = true;

            if (flag) sb.append(arr[i]);
        }

        if (!flag) System.out.println(0);
        else System.out.println(sb);
    }
}
