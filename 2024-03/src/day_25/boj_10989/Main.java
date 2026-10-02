package day_25.BOJ_B1_10989;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[10_000+1];

        for(int i=0 ; i<N ; i++){
            nums[Integer.parseInt(br.readLine())]++;
        }

        for(int i=1 ; i<=10_000 ; i++){
            for(int j=1 ; j<=nums[i] ; j++){
                bw.write(i+"\n");
            }
        }

        br.close();
        bw.close();
    }
}
