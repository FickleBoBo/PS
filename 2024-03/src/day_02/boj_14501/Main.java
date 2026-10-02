package day_02.BOJ_S3_14501;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] table = new int[1+N][2];
        int[] checkArr;
        int ans = 0;

        for(int i=1 ; i<=N ; i++){
            for(int j=0 ; j<2 ; j++){
                table[i][j] = sc.nextInt();
            }
        }

        // 비트마스크로 부분집합 추출
        for(int i=0 ; i < (1<<(N+1)) ; i++){
            int tmp = 0;
            checkArr = new int[1+N];
            for(int j=1 ; j<=N ; j++){
                if((i & (1<<j)) > 0){
                    tmp += table[j][1];
                    checkArr[j]++;
                }
            }
//            System.out.println(Arrays.toString(checkArr));
            if(!isDuplicated(checkArr, table)){
                ans = Math.max(ans, tmp);
            }
        }

        System.out.println(ans);

        sc.close();
    }

    // 상담이 같은 날 2개 이상이면 true 리턴
    static boolean isDuplicated(int[] checkArr, int[][] table) {
        int N = checkArr.length - 1;
        int[] judgeArr = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            if(checkArr[i] > 0){
                for(int j=i ; j<i+table[i][0] ; j++){
                    if(j > N){
                        return true;
                    }
                    else {
                        judgeArr[j]++;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(judgeArr));
        for(int i=1 ; i<=N ; i++){
            if(judgeArr[i] > 1) return true;
        }
        return false;
    }

}
