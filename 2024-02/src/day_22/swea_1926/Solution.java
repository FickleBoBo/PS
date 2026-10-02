package day_22.SWEA_D2_1926;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1 ; i<=N ; i++){
            if(hasD(i).isEmpty()){
                System.out.print(i + " ");
            }
            else{
                System.out.print(hasD(i) + " ");
            }
        }
        sc.close();
    }

    static String hasD(int num){

        String ans = "";

        int a = num / 10;
        int b = num % 10;
        if((b==3) || (b==6) || (b==9)){
            ans += "-";
        }
        while(a > 0){
            num /= 10;
            b = num % 10;
            a = num / 10;
            if((b==3) || (b==6) || (b==9)){
                ans += "-";
            }
        }
        return ans;
    }

}
