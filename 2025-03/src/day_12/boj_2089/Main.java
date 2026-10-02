package day_12.BOJ_2089;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            sb.append(0);
        } else {
            while (N != 0) {
                int q = N / -2;
                int r = N % -2;

                if (r < 0) {
                    q += 1;
                    r += 2;
                }

                sb.append(r);

                N = q;
            }
        }

        bw.write(sb.reverse().toString());
        bw.flush();
    }
}
