package day_27.BOJ_B1_14696;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int tc=1 ; tc<=N ; tc++){

            int a = sc.nextInt();
            int[] aArr = new int[5];
            for(int i=0 ; i<a ; i++){
                aArr[sc.nextInt()]++;
            }

            int b = sc.nextInt();
            int[] bArr = new int[5];
            for(int i=0 ; i<b ; i++){
                bArr[sc.nextInt()]++;
            }

            String ans = "D";
            for(int i=4 ; i>=0 ; i--){
                if(aArr[i] > bArr[i]){
                    ans = "A";
                    break;
                }
                else if(aArr[i] < bArr[i]){
                    ans = "B";
                    break;
                }
            }

            System.out.println(ans);

        }
        sc.close();
    }
}
