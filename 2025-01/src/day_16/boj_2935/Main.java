package day_16.BOJ_2935;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] A = br.readLine().split("");
        char operator = br.readLine().charAt(0);
        String[] B = br.readLine().split("");

        if (operator == '*') {
            sb.append(1);
            for (int i = 0; i < A.length + B.length - 2; i++) {
                sb.append(0);
            }
        } else {
            int[] ans = new int[Math.max(A.length, B.length)];

            for (int i = 0; i < A.length; i++) {
                ans[i + ans.length - A.length] += Integer.parseInt(A[i]);
            }
            for (int i = 0; i < B.length; i++) {
                ans[i + ans.length - B.length] += Integer.parseInt(B[i]);
            }

            for (int n : ans) {
                sb.append(n);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
