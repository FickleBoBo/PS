package day_22.BOJ_B1_28702;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        // 출력할 숫자
        int num = 0;

        // 입력으로 주어진 세 개의 문자열 중 하나는 반드시 숫자
        if(str1.charAt(str1.length()-1) != 'z'){
            num = Integer.parseInt(str1) + 3;
        }
        else if(str2.charAt(str2.length()-1) != 'z'){
            num = Integer.parseInt(str2) + 2;
        }
        else if(str3.charAt(str3.length()-1) != 'z'){
            num = Integer.parseInt(str3) + 1;
        }

        // 양식에 맞게 출력
        if(num % 15 == 0) System.out.println("FizzBuzz");
        else if(num % 3 == 0) System.out.println("Fizz");
        else if(num % 5 == 0) System.out.println("Buzz");
        else System.out.println(num);
    }
}
