package day_08.BOJ_2857;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 5; tc++) {
            String name = br.readLine();

            if (name.contains("FBI")) sb.append(tc).append(" ");
        }

        if (sb.toString().isEmpty()) sb.append("HE GOT AWAY!");

        bw.write(sb.toString());
        bw.flush();
    }
}
