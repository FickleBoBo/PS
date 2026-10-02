package day_26.BOJ_B3_2562;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int idx = 1;

        for(int i=1 ; i<=9 ; i++){
            int num = Integer.parseInt(br.readLine());

            if(num > max){
                max = num;
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}
