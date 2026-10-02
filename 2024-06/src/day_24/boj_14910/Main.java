package day_24.BOJ_B2_14910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean flag = true;
        int n = Integer.MIN_VALUE;
        while(st.hasMoreTokens()){
            int next = Integer.parseInt(st.nextToken());
            if(n > next){
                flag = false;
                break;
            }
            n = next;
        }

        System.out.println(flag ? "Good" : "Bad");
    }
}
