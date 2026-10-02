package day_05.BOJ_B2_2908;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String input1 = st.nextToken();
        String input2 = st.nextToken();

        int num1 = 0;
        int num2 = 0;

        int digit = 1;
        for(int i=0 ; i<3 ; i++){
            num1 += Character.getNumericValue(input1.charAt(i)) * digit;
            num2 += Character.getNumericValue(input2.charAt(i)) * digit;
            digit *= 10;
        }

        System.out.println(Math.max(num1, num2));
    }
}
