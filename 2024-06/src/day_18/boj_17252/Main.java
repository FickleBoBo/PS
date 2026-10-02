package day_18.BOJ_S4_17252;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N == 0){
            System.out.println("NO");
        }
        else{
            int div = 1162261467;
            while(div > 0){
                if(N >= div){
                    N -= div;
                }
                div /= 3;
            }
            System.out.println(N==0 ? "YES" : "NO");
        }
    }
}
