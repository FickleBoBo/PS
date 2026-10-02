package day_04.BOJ_S1_12852_Fail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] DP = new int[1+N];
        DP[0] = -1;
        for(int i=1 ; i<=N ; i++){
            if(i%2!=0 && i%3!=0) {
                DP[i] = DP[i-1] + 1;
            }
            if(i%2==0) {
                if(DP[i-1] > DP[i/2]){
                    DP[i] = DP[i/2] + 1;
                }
                else{
                    DP[i] = DP[i-1] + 1;
                }
            }
            if(i%3==0) {
                if(DP[i-1] > DP[i/3]){
                    DP[i] = DP[i/3] + 1;
                }
                else{
                    DP[i] = DP[i-1] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(DP[N]);
        sb.append(N + " ");

        while(N != 1){
            if(N%3 == 0){
                if(DP[N-1] > DP[N/3]){
                    sb.append(N/3 + " ");
                    N /= 3;
                }
                else{
                    sb.append(N-1 + " ");
                    N -= 1;
                }
            }
            else if(N%2 == 0){
                if(DP[N-1] > DP[N/2]){
                    sb.append(N/2 + " ");
                    N /= 2;
                }
                else{
                    sb.append(N-1 + " ");
                    N -= 1;
                }
            }
            else{
                if(DP[N-1] < DP[N/2] && DP[N-1] < DP[N/3]){
                    sb.append(N-1 + " ");
                    N -= 1;
                }
            }
        }

        System.out.println(sb.toString());

        sc.close();
    }
}
