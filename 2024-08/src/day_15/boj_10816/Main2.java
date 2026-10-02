package day_15.BOJ_S4_10816;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<M ; i++){
            int num = Integer.parseInt(st.nextToken());

            // 매개변수 이분탐색으로 특정 원소의 개수 탐색 가능
            // binarySearchUpperBound 는 num을 초과하는 원소의 최소 인덱스 반환
            // binarySearchLowerBound 는 num 이상인 원소의 최소 인덱스 반환
            int result = binarySearchUpperBound(arr, num) - binarySearchLowerBound(arr, num);

            sb.append(result).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int binarySearchUpperBound(int[] arr, int value){
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid] <= value){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return right;
    }

    private static int binarySearchLowerBound(int[] arr, int value){
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid] < value){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return right;
    }
}
