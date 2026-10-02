package day_19.BOJ_2108;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 4000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] arr = new int[N];
        int[] cntArr = new int[MAX + 1 + MAX];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            cntArr[MAX + arr[i]]++;
        }
        Arrays.sort(arr);

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] > max) {
                max = cntArr[i];
                cnt = 1;
            } else if (cntArr[i] == max) {
                cnt++;
            }
        }
        cnt = Math.min(cnt, 2);

        int mode = 0;
        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] == max) cnt--;

            if (cnt == 0) {
                mode = i - MAX;
                break;
            }
        }

        sb
                .append(Math.round((double) sum / N)).append("\n")
                .append(arr[N / 2]).append("\n")
                .append(mode).append("\n")
                .append(arr[N - 1] - arr[0]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}
