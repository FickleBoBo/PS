package day_01.BOJ_2588;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        sb
                .append(num1 * (num2 % 10)).append("\n")
                .append(num1 * (num2 % 100 / 10)).append("\n")
                .append(num1 * (num2 / 100)).append("\n")
                .append(num1 * num2);

        bw.write(sb.toString());
        bw.flush();
    }
}
