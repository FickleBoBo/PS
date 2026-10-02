package day_26.BOJ_B3_5597;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[1+30];

        for(int i=0 ; i<28 ; i++){
            arr[Integer.parseInt(br.readLine())] = true;
        }

        for(int i=1 ; i<=30 ; i++){
            if(!arr[i]){
                System.out.println(i);
            }
        }
    }
}
