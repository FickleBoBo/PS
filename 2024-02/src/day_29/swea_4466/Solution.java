package day_29.SWEA_D3_4466;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] nums = new int[N];
            for(int i=0 ; i<N ; i++){
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            int ans = 0;
            for(int i=N-1 ; i>=N-K ; i--){
                ans += nums[i];
            }
            System.out.printf("#%d %d\n", tc, ans);
        }
        sc.close();
    }
}
