package day_15.BOJ_G3_2473;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 용액의 특성을 배열에 저장한 후 정렬
        // 세 용액의 합을 계산하는 과정에서 int형 오버플로우가 발생할 수 있어서 미리 long 타입으로 받음(테스트 케이스 39%)
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        // 0에 가까운지를 판단하며 용액의 특성을 저장
        long ans = Long.MAX_VALUE;
        long[] ansArr = new long[3];

        out:
        for(int i=0 ; i<N-2 ; i++){
            int left = i + 1;
            int right = N - 1;

            // 투 포인터 알고리즘
            while(left < right){
                long sum = arr[i] + arr[left] + arr[right];

                // 갱신 조건
                if(Math.abs(ans) > Math.abs(sum)){
                    ans = sum;
                    ansArr[0] = arr[i];
                    ansArr[1] = arr[left];
                    ansArr[2] = arr[right];
                }

                // 포인터 이동 조건
                if(sum > 0) right--;
                else if(sum < 0) left++;
                else break out;
            }
        }

        sb.append(ansArr[0]).append(" ").append(ansArr[1]).append(" ").append(ansArr[2]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
