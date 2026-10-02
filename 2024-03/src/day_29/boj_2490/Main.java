package day_29.BOJ_B3_2490;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int i=0 ; i<3 ; i++){
            int ans = 0;
            for(int j=0 ; j<4 ; j++){
                ans += sc.nextInt();
            }
            switch (ans){
                case 3:{
                    System.out.println('A');
                    break;
                }
                case 2:{
                    System.out.println('B');
                    break;
                }
                case 1:{
                    System.out.println('C');
                    break;
                }
                case 0:{
                    System.out.println('D');
                    break;
                }
                default:{
                    System.out.println('E');
                }
            }
        }

        sc.close();
    }
}
