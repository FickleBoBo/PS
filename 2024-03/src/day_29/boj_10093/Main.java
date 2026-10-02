package day_29.BOJ_B2_10093;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        long A = sc.nextLong();
        long B = sc.nextLong();

        if(A > B){
            System.out.println(A-B-1);
            for(long i=B+1 ; i<A ; i++){
                sb.append(i+ " ");
            }
            System.out.println(sb.toString());
        }
        else if (A < B){
            System.out.println(B-A-1);
            for(long i=A+1 ; i<B ; i++){
                sb.append(i+ " ");
            }
            System.out.println(sb.toString());
        }
        else{
            System.out.println(0);
        }
        sc.close();
    }
}
