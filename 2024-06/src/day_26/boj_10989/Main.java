package day_26.BOJ_B1_10989;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] cntArr = new int[1+10000];
        for(int i=0 ; i<N ; i++){
            cntArr[Integer.parseInt(br.readLine())]++;
        }

        for(int i=1 ; i<=10000 ; i++){
            for(int j=0 ; j<cntArr[i] ; j++){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
