package day_26.BOJ_1254;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        while (true) {
            if (isPalindrome(input)) {
                System.out.println(input.length());
                return;
            }

            input = new StringBuilder(input).append("*").toString();
        }
    }

    private static boolean isPalindrome(String str) {
        boolean flag = true;

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(str.length() - 1 - i) == '*') continue;

            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                flag = false;
                break;
            }
        }

        return flag;
    }

}
