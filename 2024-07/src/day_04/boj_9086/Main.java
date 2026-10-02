package day_04.BOJ_B5_9086;

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            String input = br.readLine();

            sb.append(input.charAt(0)).append(input.charAt(input.length()-1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
