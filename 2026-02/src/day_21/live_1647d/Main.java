package day_21.ksa_d;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }
}
// 1 2 4 5 3
// 5 3 1 2 4
// 1 2 5 3 4
// 3 4 1 2 5
// 1 2 3 4 5

// 2 3 1
// 3 1 2
// 1 2 3

// 1 2 4 5 3
// 1 2 5 3 4

// 1 3 2
// 2 1 3
// 3 2 1
