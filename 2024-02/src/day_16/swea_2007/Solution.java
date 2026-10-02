package day_16.SWEA_D2_2007;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int ans = 0;
            String input = sc.next();
            for(int i=input.length()/2 ; i>0 ; i--){    // 역순으로 해야 최소 길이가 잘 나옴
                if(input.substring(0, i).equals(input.substring(i, 2 * i))){
                    ans = i;
                }
            }
            System.out.printf("#%d %d\n", tc, ans);
        }
        sc.close();
    }
}
