package day_30.BOJ_B3_10990;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int left = N-1;
        int right= N-1;

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<2*N-1 ; j++){
                if(j==right){
                    bw.write("*");
                    break;
                }
                else if(j==left){
                    bw.write("*");
                }
                else{
                    bw.write(" ");
                }
            }
            bw.write("\n");

            left--;
            right++;
        }

        bw.flush();
        bw.close();
    }
}
