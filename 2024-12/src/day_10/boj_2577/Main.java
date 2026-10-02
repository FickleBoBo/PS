package day_10.BOJ_2577;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        char[] mul = Integer.toString(A * B * C).toCharArray();
        int[] cntArr = new int[10];

        for (char c : mul) {
            cntArr[c - '0']++;
        }

        for (int cnt : cntArr) {
            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
