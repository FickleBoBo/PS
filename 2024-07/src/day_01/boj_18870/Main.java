package day_01.BOJ_S2_18870;

import java.io.*;
import java.util.*;

public class Main_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        int[] sortedArr = new int[set.size()];
        int idx = 0;
        for(int key : set){
            sortedArr[idx++] = key;
        }
        Arrays.sort(sortedArr);

        for(int i=0 ; i<N ; i++){
            sb.append(binarySearch(sortedArr, 0, sortedArr.length, arr[i])).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int binarySearch(int[] arr, int left, int right, int target){
        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] < target){
                left = mid + 1;
            }
            else if(arr[mid] > target){
                right = mid - 1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }

}
