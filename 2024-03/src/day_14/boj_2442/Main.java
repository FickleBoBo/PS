package day_14.BOJ_B3_2442;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1 ; i<=N ; i++){
            for(int j=N-1 ; j>=i ; j--){
                System.out.print(" ");
            }
            for(int j=1 ; j<2*i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
