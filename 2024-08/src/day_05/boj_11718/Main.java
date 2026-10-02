package day_05.BOJ_B3_11718;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while((input = br.readLine()) != null){
            sb.append(input).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
