package day_02.BOJ_S2_1182;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int ans;
    static int[] nums;
    static int N;
    static int S;
    static int[] sel;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        ans = 0;
        sel = new int[2];

        nums = new int[N];
        for(int i=0 ; i<N ; i++) {
            nums[i] = sc.nextInt();
        }

//        combination(0, 0);

        for(int i=1 ; i< (1<<N) ; i++){
            int[] tmp = new int[N];
            for(int j=0 ; j<N ; j++){
                if((i & (1<<j)) > 0){
                    tmp[j] = 1;
                }
            }
            int sum = 0;
            for(int k=0 ; k<N ; k++){
                if(tmp[k] > 0){
                    sum += nums[k];
                }
            }
//            System.out.println(Arrays.toString(tmp));
            if(sum == S){
                ans++;
            }
        }

        System.out.println(ans);

        sc.close();
    }

//    static void combination(int idx, int sidx){
//        if(sidx == 2){
//            System.out.println(Arrays.toString(sel));
//            int sum = 0;
//            for(int i=sel[0] ; i<=sel[1] ; i++){
//                sum += nums[i];
//            }
//            if(sum == S){
//                ans++;
//            }
//            return;
//        }
//
//        for(int i=idx ; i<N ; i++){
//            sel[sidx] = i;
//            combination(i, sidx+1);
//        }
//    }

}
