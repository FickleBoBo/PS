package day_28.BOJ_B3_4458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0 ; i<N ; i++){
            String[] input = br.readLine().split("");
            input[0] = input[0].toUpperCase();
            for(int j=0 ; j<input.length ; j++){
                System.out.print(input[j]);
            }
            System.out.println();
        }
    }
}
