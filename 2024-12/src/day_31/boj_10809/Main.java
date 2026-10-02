package day_31.BOJ_10809;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();

        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < S.length(); i++) {
            if (arr[S.charAt(i) - 'a'] == -1) arr[S.charAt(i) - 'a'] = i;
        }

        for (int idx : arr) {
            sb.append(idx).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
