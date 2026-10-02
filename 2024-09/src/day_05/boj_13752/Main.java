package day_05.BOJ_B4_13752;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            int k = Integer.parseInt(br.readLine());

            for(int i=0 ; i<k ; i++){
                bw.write("=");
            }
            bw.newLine();
        }

        bw.flush();
    }
}
