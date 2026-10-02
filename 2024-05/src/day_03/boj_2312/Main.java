package day_03.BOJ_S3_2312;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int[] arr = new int[1+N];
            while(N>1){
                for(int i=2 ; i<=N ; i++){
                    if(N%i==0){
                        arr[i]++;
                        N /= i;
                        break;
                    }
                }
            }
            for(int i=2 ; i<arr.length ; i++){
                if(arr[i]!=0){
                    System.out.println(i + " " + arr[i]);
                }
            }
        }

    }
}
