package day_05.BOJ_10989;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        final int MAX = 10_000;
        int[] cntArr = new int[1 + MAX];
        for (int i = 0; i < N; i++) {
            cntArr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < cntArr.length; i++) {
            for (int j = 0; j < cntArr[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
