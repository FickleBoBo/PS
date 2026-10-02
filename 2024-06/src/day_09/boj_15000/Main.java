package day_09.BOJ_B5_15000;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        for(char c : input){
            System.out.print(Character.toUpperCase(c));
        }
    }
}