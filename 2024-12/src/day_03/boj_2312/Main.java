package day_03.BOJ_2312;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 2; i * i <= N; i++) {
                int q = 0;

                while (N % i == 0) {
                    N /= i;
                    q++;
                }

                if (q == 0) continue;

                sb.append(i).append(" ").append(q).append("\n");
            }

            if (N > 1) {
                sb.append(N).append(" ").append(1).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
