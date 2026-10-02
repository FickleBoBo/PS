package day_02.BOJ_5988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String K = br.readLine();
            int num = K.charAt(K.length() - 1) - '0';

            bw.write(num % 2 == 0 ? "even\n" : "odd\n");
        }

        bw.flush();
    }
}
