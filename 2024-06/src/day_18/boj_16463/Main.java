package day_18.BOJ_S3_16463;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;

        // 일 0 금 5
        int day = 2;
        for(int i=2019 ; i<=N ; i++){
            boolean has0229 = false;
            if(i % 400 == 0){
                has0229 = true;
            }
            else if(i % 100 == 0){
                has0229 = false;
            }
            else if(i % 4 == 0){
                has0229 = true;
            }

            for(int j=1 ; j<=12 ; j++){
                if((day + 12) % 7 == 5){
                    cnt++;
                }

                if(j == 1) day = (day + 31) % 7;
                if(j == 2 && has0229) day = (day + 29) % 7;
                if(j == 2 && !has0229) day = (day + 28) % 7;
                if(j == 3) day = (day + 31) % 7;
                if(j == 4) day = (day + 30) % 7;
                if(j == 5) day = (day + 31) % 7;
                if(j == 6) day = (day + 30) % 7;
                if(j == 7) day = (day + 31) % 7;
                if(j == 8) day = (day + 31) % 7;
                if(j == 9) day = (day + 30) % 7;
                if(j == 10) day = (day + 31) % 7;
                if(j == 11) day = (day + 30) % 7;
                if(j == 12) day = (day + 31) % 7;
            }
        }

        System.out.println(cnt);
    }
}
