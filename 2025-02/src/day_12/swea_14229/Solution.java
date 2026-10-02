package day_12.SWEA_14229;

import java.io.*;
import java.util.*;

public class Solution {

    private static final int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(Solution.class.getResourceAsStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(arr[MAX / 2]);
    }
}
