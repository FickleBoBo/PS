package day_18.BOJ_B3_5354;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            int N = Integer.parseInt(br.readLine());

            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    if(i==0 || i == N-1 || j==0 || j == N-1){
                        bw.write("#");
                    }
                    else{
                        bw.write("J");
                    }
                }
                bw.write("\n");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
