package day_17.SWEA_D3_7964;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int D = sc.nextInt();
            int[] cities = new int[1+N+1];
            for(int i=1 ; i<=N ; i++){
                cities[i] = sc.nextInt();
            }
            cities[0] = 1;
            cities[cities.length-1] = 1;

            int ans = 0;
            for(int i=1; i<=N ; i++){
                if(cities[i]==0){
                    int cnt = 0;
                    while(cities[i]==0){
                        cnt++;
                        i++;
                    }
                    ans += cnt / D;
                }
            }
            System.out.printf("#%d %d\n", tc, ans);
        }
        sc.close();
    }
}
