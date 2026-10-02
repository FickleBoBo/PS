package day_14.BOJ_B3_2445;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1 ; i<=N ; i++){
            for(int j=0 ; j<i ; j++){
                System.out.print("*");
            }
            for(int j=2*i ; j<2*N ; j++){
                System.out.print(" ");
            }
            for(int j=0 ; j<i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=N-1 ; i>0 ; i--){
            for(int j=0 ; j<i ; j++){
                System.out.print("*");
            }
            for(int j=2*i ; j<2*N ; j++){
                System.out.print(" ");
            }
            for(int j=0 ; j<i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
