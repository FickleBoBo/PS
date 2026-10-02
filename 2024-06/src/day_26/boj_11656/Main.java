package day_26.BOJ_S4_11656;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();

        String[] arr = new String[S.length()];
        for(int i=0 ; i< arr.length ; i++){
            arr[i] = S.substring(i);
        }

        Arrays.sort(arr);
        for(String s : arr){
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
