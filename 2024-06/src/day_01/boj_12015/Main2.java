package day_01.BOJ_G2_12015;

import java.io.*;
import java.util.StringTokenizer;

public class Main_fin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0 ; i<N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 앞에 1은 패딩으로 인덱스 1부터 실제 값이 저장됨
        int[] dp = new int[1+N];
        int maxLen = 1;    // 이분 탐색하는 배열의 실제 길이(패딩 제외)

        for(int i=0 ; i<N ; i++){
            int idx = binarySearchLowerBound(dp, 1, maxLen, A[i]);

            if(idx < maxLen){
                dp[idx] = A[i];
            }
            else{    // dp 배열에서 같거나 큰 원소를 발견하지 못하면 배열 뒤에 삽입하고 길이 늘림
                dp[maxLen++] = A[i];
            }
        }

        System.out.println(maxLen-1);
    }

    // target 보다 같거나 큰 인덱스를 반환
    // left는 배열의 가장 왼쪽 원소의 인덱스
    // right는 배열의 가장 오른족 원소의 인덱스 + 1
    private static int binarySearchLowerBound(int[] arr, int left, int right, int target){
        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return right;
    }

}
