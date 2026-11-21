package day_21.boj_2587;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(sum / 5);
        System.out.println(arr[2]);
    }
}
