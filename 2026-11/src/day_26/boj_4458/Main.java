package day_26.boj_4458;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String line = br.readLine();

            bw.write(Character.toUpperCase(line.charAt(0)));
            bw.write(line.substring(1));
            bw.newLine();
        }

        bw.flush();
    }
}
