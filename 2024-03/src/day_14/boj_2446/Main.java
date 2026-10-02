package day_14.BOJ_B3_2446;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int lft = 1;
        int rgt = 2*N-1;
        boolean flag = true;
        for(int i=1 ; i<2*N ; i++){
            for(int j=1 ; j<lft ; j++){
                System.out.print(" ");
            }
            for(int j=lft ; j<=rgt ; j++){
                System.out.print("*");
            }
            System.out.println();

            if(lft >= rgt){
                flag = false;
            }

            if(flag){
                lft++;
                rgt--;
            }
            else{
                lft--;
                rgt++;
            }
        }
        sc.close();
    }
}
