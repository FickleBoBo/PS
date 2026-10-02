package day_04.BOJ_5648;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            sb.append(input).append(" ");
        }
        st = new StringTokenizer(sb.toString());

        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(new StringBuilder(st.nextToken()).reverse().toString());
        }
        Arrays.sort(arr);

        sb = new StringBuilder();
        for (long n : arr) {
            sb.append(n).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
