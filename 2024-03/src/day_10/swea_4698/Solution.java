package day_10.SWEA_D3_4698;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        boolean[] notPrimeNums = new boolean[1_000_000 + 1];
        notPrimeNums[1] = true;

        for(int i=1 ; i<=1_000_000 ; i++){
            for(int j=2 ; j<=Math.sqrt(i) ; j++){
                if(i % j == 0){
                    notPrimeNums[i] = true;
                    break;
                }
            }
        }

        for(int tc=1 ; tc<=T ; tc++){
            int D = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int cnt = 0;

            for(int i=A ; i<=B ; i++){
                if(!notPrimeNums[i]){
                    if((i+"").contains(D+"")){
                        cnt++;
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, cnt);
        }

        sc.close();
    }
}
