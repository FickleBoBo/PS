package day_26.BOJ_S5_2751;

import java.io.*;

public class Main_counting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        boolean[] checkArr = new boolean[1000000+1+1000000];
        for(int i=0 ; i<N ; i++){
            checkArr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        for(int i=0 ; i<=2000000 ; i++){
            if(checkArr[i]){
                sb.append(i-1000000).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
