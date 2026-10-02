package day_20.BOJ_B3_14215;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];

        for(int i=0 ; i<3 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if(arr[2] >= arr[0] + arr[1]) System.out.println((arr[0] + arr[1]) * 2 - 1);
        else System.out.println(arr[0] + arr[1] + arr[2]);
    }
}
