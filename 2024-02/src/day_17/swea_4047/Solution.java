package day_17.SWEA_D3_4047;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){

            int[] listS = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            int[] listD = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            int[] listH = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            int[] listC = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

            boolean error = false;
            String S = sc.next();
            String[] SArr = S.split("");

            for(int i=0 ; i<SArr.length ; i+=3){
                int num = Integer.parseInt(S.substring(i+1, i+3));

                if(SArr[i].equals("S")){
                    listS[num]--;
                }
                else if(SArr[i].equals("D")){
                    listD[num]--;
                }
                else if(SArr[i].equals("H")){
                    listH[num]--;
                }
                else if(SArr[i].equals("C")){
                    listC[num]--;
                }
            }

            for(int i=1 ; i<=13 ; i++){
                if((listS[i]==-1) || (listD[i]==-1) || (listH[i]==-1) || (listC[i]==-1)) {
                    error = true;
                    break;
                }
            }

            if(error){
                System.out.printf("#%d ERROR\n", tc);
            }
            else{
                int sumS = 0;
                int sumD = 0;
                int sumH = 0;
                int sumC = 0;
                for(int i=1 ; i<=13 ; i++){
                    sumS += listS[i];
                }
                for(int i=1 ; i<=13 ; i++){
                    sumD += listD[i];
                }
                for(int i=1 ; i<=13 ; i++){
                    sumH += listH[i];
                }
                for(int i=1 ; i<=13 ; i++){
                    sumC += listC[i];
                }
                System.out.printf("#%d %d %d %d %d\n", tc, sumS, sumD, sumH, sumC);
            }
        }
        sc.close();
    }
}
