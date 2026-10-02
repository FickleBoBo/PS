package day_06.BOJ_B2_1550;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();

        int ans = 0;
        for(int i=0 ; i<input.length ; i++){
            int tmp = 0;
            if(input[i] >= 'A'){
                tmp = (input[i] - 55);
            }
            else{
                tmp = Character.getNumericValue(input[i]);
            }
            for(int j=1 ; j<input.length - i ; j++){
                tmp *= 16;
            }
            ans += tmp;
        }

        System.out.println(ans);
    }
}
