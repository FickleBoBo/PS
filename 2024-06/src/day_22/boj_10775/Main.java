package day_22.BOJ_G2_10775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int[] checkArr = new int[1+G];
        for(int i=1 ; i<=G ; i++){
            checkArr[i] = i;
        }
        boolean[] visited = new boolean[1+G];

        int cnt = 0;

        out:
        for(int i=0 ; i<P ; i++){
            int g = Integer.parseInt(br.readLine());

            for(int j=checkArr[g] ; j>0 ; j--){
                if(!visited[j]){
                    visited[j] = true;
                    checkArr[g] = j;
                    cnt++;
                    continue out;
                }
            }

            break;
        }

        System.out.println(cnt);
    }
}
