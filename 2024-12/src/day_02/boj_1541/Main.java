package day_02.BOJ_1541;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int ans = sum(st.nextToken());

        while (st.hasMoreTokens()) {
            ans -= sum(st.nextToken());
        }

        System.out.println(ans);
    }

    // + 부호로 이어진 수의 합
    private static int sum(String token) {
        StringTokenizer st = new StringTokenizer(token, "+");
        int sum = 0;
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        return sum;
    }

}
