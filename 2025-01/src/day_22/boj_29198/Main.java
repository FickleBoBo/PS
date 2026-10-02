package day_22.BOJ_29198;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            Arrays.sort(input);

            sb = new StringBuilder();
            for (char c : input) {
                sb.append(c);
            }

            arr[i] = sb.toString();
        }
        Arrays.sort(arr);

        sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            sb.append(arr[i]);
        }

        char[] charArr = sb.toString().toCharArray();
        Arrays.sort(charArr);

        sb = new StringBuilder();
        for (char c : charArr) {
            sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
