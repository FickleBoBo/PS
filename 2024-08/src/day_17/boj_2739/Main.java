package day_17.BOJ_B5_2739;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=1 ; i<=9 ; i++){
            sb.append(N).append(" * ").append(i).append(" = ").append(N * i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
