package day_18.BOJ_B3_2566;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int maxR = -1;
        int maxC = -1;

        for(int i=1 ; i<=9 ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=9 ; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num >= max){
                    max = num;
                    maxR = i;
                    maxC = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxR + " " + maxC);
    }
}
