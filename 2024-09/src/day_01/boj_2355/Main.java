package day_01.BOJ_B2_2355;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        if(A > B){
            long tmp = A;
            A = B;
            B = tmp;
        }

        long sum = (A + B) * (B - A + 1) / 2;

        System.out.println(sum);
    }
}
