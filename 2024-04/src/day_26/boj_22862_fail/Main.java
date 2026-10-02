package day_26.BOJ_G5_22862_Fail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        int start = 0;
        int end = 1;
        if(arr[start] % 2 == 1){
            cnt--;
        }

        while(true){
            if(cnt >= 0){
                if(arr[end++] % 2 == 1){
                    cnt--;
                }
            }
            else{
                if(arr[start++] % 2 == 1){
                    cnt++;
                }
            }

            if(end == N) break;
        }

        System.out.println(start);
        System.out.println(end);
        System.out.println(cnt);

        int ans = end - start + 1 - (K-cnt);
        System.out.println(ans);

        sc.close();
    }
}
