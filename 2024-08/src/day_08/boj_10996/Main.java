package day_08.BOJ_B2_10996;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=1 ; i<=2 * N ; i++){
            for(int j=1 ; j<=N ; j++){
                if((i + j) % 2 == 0){
                    sb.append("*");
                }
                else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
