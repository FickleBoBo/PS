package day_03.BOJ_S5_1789;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();

        long N = 1;
        while(true){
            if(S >= N*(N+1)/2 && S < (N+1)*(N+2)/2){
                break;
            }
            N++;
        }

        System.out.println(N);
    }
}
