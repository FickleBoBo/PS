package day_20.BOJ_G5_11729_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void Hanoi(int N, int from, int tmp, int to){
        if(N==1){
            System.out.println(from + " " + to);
            return;
        }
        Hanoi(N-1, from, to, tmp);
        System.out.println(from + " " + to);
        Hanoi(N-1, tmp, from, to);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = (int) Math.pow(2, N) - 1;

        System.out.println(cnt);
        Hanoi(N, 1, 2, 3);

        br.close();
    }
}
