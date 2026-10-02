package day_13.BOJ_S4_11656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String[] arr = new String[str.length()];
        for(int i=0 ; i<str.length() ; i++){
            arr[i] = str.substring(i);
        }

        Arrays.sort(arr);

        for(String s : arr){
            System.out.println(s);
        }
    }
}
