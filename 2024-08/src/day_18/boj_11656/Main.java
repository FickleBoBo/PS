package day_18.BOJ_S4_11656;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        String[] arr = new String[S.length()];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = S.substring(i);
        }

        Arrays.sort(arr);

        for(String s : arr){
            bw.write(s);
            bw.write("\n");
        }

        bw.flush();
    }
}
