package day_30.BOJ_B3_1267;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Y = 0;
        int M = 0;

        for(int i=0 ; i<N ; i++){
            int time = sc.nextInt();
            Y += ((time / 30)+1) * 10;
            M += ((time / 60)+1) * 15;
        }

        if(Y > M) System.out.printf("M %d\n", M);
        else if (Y < M) System.out.printf("Y %d\n", Y);
        else System.out.printf("Y M %d\n", Y);

        sc.close();
    }
}
