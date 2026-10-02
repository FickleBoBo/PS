package day_13.BOJ_S2_2805;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearchUpperBound(arr, 0, 1000000000, M));
    }

    // 이분 탐색 목표 : 내가 설정한 높이로 나무를 잘랐을 때 남는 나무가 M(=target) 이상이어야 함
    // 절단기의 높이는 tree가 target 미만일 때까지 높여야 함 + 그리고 절단기의 높이를 1 낮추면 target 이상의 나무를 얻을 수 있음
    // binarySearchUpperBound를 적용해 절단기의 높이를 올려줌
    private static int binarySearchUpperBound(int[] arr, int left, int right, int target){
        int N = arr.length;

        while(left < right){
            // mid는 내가 설정한 절단기의 높이
            int mid = (left + right) / 2;    // 이 문제는 10억까지라 괜찮은데 int 범위를 넘어가는 문제도 있음

            // 절단기 높이에 대해 잘린 나무의 길이의 합
            long tree = 0;    // int 범위를 넘어갈 수 있음(테케 2% 조건)
            for(int i=0 ; i<N ; i++){
                tree += Math.max(arr[i] - mid, 0);
            }

            // 부등호 조건 주의
            if(tree >= target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return right - 1;
    }

}
