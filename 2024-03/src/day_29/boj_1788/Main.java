package day_29.BOJ_S3_1788;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] fibo = new long[Math.abs(n)+2];
        fibo[1] = 1;
        if(n>=2){
            for(int i=2 ; i<=n ; i++){
                fibo[i] = (fibo[i-1] + fibo[i-2])%1_000_000_000;
            }
        }
        else if(n<0){
            for(int i=2 ; i<=(-n) ; i++){
                fibo[i] = (fibo[i-2] - fibo[i-1])%1_000_000_000;
            }
        }

        if(fibo[Math.abs(n)]>0) System.out.println(1);
        else if(fibo[Math.abs(n)]<0) System.out.println(-1);
        else System.out.println(0);
        System.out.println(Math.abs(fibo[Math.abs(n)]));

        sc.close();
    }
}
