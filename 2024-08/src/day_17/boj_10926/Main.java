package day_17.BOJ_B5_10926;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String id = br.readLine();

        bw.write(id);
        bw.write("??!");
        bw.flush();
    }
}
