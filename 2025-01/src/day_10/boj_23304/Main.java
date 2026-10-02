package day_10.BOJ_23304;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        if (isAkarakaPalindrome(input)) System.out.println("AKARAKA");
        else System.out.println("IPSELENTI");
    }

    private static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    private static boolean isAkarakaPalindrome(String str) {
        if (str.length() == 1) return true;
        return isPalindrome(str) && isAkarakaPalindrome(str.substring(0, str.length() / 2)) && isAkarakaPalindrome(str.substring((str.length() + 1) / 2));
    }

}
