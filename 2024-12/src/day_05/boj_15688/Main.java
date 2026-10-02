package day_05.BOJ_15688;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        final int MAX = 1_000_000;
        int[] cntArr = new int[MAX + 1 + MAX];
        for (int i = 0; i < N; i++) {
            cntArr[Integer.parseInt(br.readLine()) + MAX]++;
        }

        for (int i = 0; i < cntArr.length; i++) {
            for (int j = 0; j < cntArr[i]; j++) {
                sb.append(i - MAX).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
