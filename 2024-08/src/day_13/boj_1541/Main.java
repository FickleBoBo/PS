package day_13.BOJ_S2_1541;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

        int sum = 0;

        while(st2.hasMoreTokens()){
            sum += Integer.parseInt(st2.nextToken());
        }

        while(st.hasMoreTokens()){
            st2 = new StringTokenizer(st.nextToken(), "+");

            int tmp = 0;

            while(st2.hasMoreTokens()){
                tmp += Integer.parseInt(st2.nextToken());
            }

            sum -= tmp;
        }

        System.out.println(sum);
    }
}
