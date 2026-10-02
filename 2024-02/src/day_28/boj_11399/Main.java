package day_28.BOJ_S4_11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 최솟값은 시간이 적게 걸리는 사람부터 줄을 설 때라 입력 받고 정렬을 해줌
        // 총 걸린 시간은 앞사람의 시간과 자신의 시간만큼 모든 사람이 걸리므로 누적합의 총합으로 구할 수 있음

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int[] prefixArr = new int[1+N];

        int ans = 0;
        for(int i=0 ; i<N ; i++){
            prefixArr[i+1] = prefixArr[i] + arr[i];
            ans += prefixArr[i+1];
        }

        System.out.println(ans);

        sc.close();
    }
}
