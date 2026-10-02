package day_13.BOJ_B3_2921;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i=1 ; i<=N ; i++){
            for(int j=0 ; j<=i ; j++){
                cnt += i;
                cnt += j;
            }
        }

        System.out.println(cnt);
    }
}
