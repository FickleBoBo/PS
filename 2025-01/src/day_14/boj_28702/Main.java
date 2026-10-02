package day_14.BOJ_28702;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num1 = br.readLine();
        String num2 = br.readLine();
        String num3 = br.readLine();

        int num;

        if (isNumber(num1)) num = Integer.parseInt(num1) + 3;
        else if (isNumber(num2)) num = Integer.parseInt(num2) + 2;
        else num = Integer.parseInt(num3) + 1;

        System.out.println(getFizzBuzzNumber(num));
    }

    private static boolean isNumber(String str) {
        return !str.equals("Fizz") && !str.equals("Buzz") && !str.equals("FizzBuzz");
    }

    private static String getFizzBuzzNumber(int num) {
        if (num % 15 == 0) return "FizzBuzz";
        else if (num % 3 == 0) return "Fizz";
        else if (num % 5 == 0) return "Buzz";
        else return Integer.toString(num);
    }

}
