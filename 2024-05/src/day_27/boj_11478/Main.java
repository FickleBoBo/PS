package day_27.BOJ_S3_11478;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int len = input.length();

        Set<String> set = new HashSet<>();
        for(int i=0 ; i<len ; i++){
            for(int j=i+1 ; j<=len ; j++){
                set.add(input.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}
