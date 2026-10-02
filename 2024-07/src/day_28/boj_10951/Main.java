package day_28.BOJ_B5_10951;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input;

        while(true){
            input = br.readLine();
            if(input == null) break;

            st = new StringTokenizer(input);

            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
