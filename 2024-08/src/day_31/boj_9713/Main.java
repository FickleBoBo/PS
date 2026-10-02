package day_31.BOJ_B3_9713;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            int N = Integer.parseInt(br.readLine());

            sb.append(((N + 1) / 2) * ((N + 1) / 2)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
