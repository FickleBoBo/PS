package day_31.BOJ_11365;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("END")) break;

            sb.append(new StringBuilder(input).reverse()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
