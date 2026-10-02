package day_31.BOJ_25372;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String password = br.readLine();

            if (password.length() >= 6 && password.length() <= 9) bw.write("yes\n");
            else bw.write("no\n");
        }

        bw.flush();
    }
}
