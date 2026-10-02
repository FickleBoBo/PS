package day_04.BOJ_14215;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        Arrays.sort(arr);

        int a = arr[0];
        int b = arr[1];
        int c = a + b > arr[2] ? arr[2] : a + b - 1;

        System.out.println(a + b + c);
    }
}
