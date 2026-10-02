package day_01.BOJ_B3_2566;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int max = -1;
        int maxRow = -1;
        int maxCol = -1;

        for(int i=1 ; i<=9 ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=9 ; j++){
                int num = Integer.parseInt(st.nextToken());

                if(num > max){
                    max = num;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        sb.append(max).append("\n").append(maxRow).append(" ").append(maxCol);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
