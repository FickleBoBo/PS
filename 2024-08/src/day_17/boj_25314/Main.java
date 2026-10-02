package day_17.BOJ_B5_25314;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()) / 4;

        for(int i=1 ; i<=N ; i++){
            bw.write("long ");
        }
        bw.write("int");
        bw.flush();
    }
}
