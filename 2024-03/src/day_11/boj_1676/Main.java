package day_11.BOJ_S5_1676;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        /* 팩토리얼을 직접 구하기엔 N이 너무 크다
        *  long으로도 안돼서 문자열 써야함
        *  팩토리얼의 0의 개수에서 N이 3자리까지일때 이전 팩토리얼의 3번째를 넘어가는 자리수는
        * 영향을 미치지 않음
        * */
        int cnt = 0;
        int num = 1;
        for(int i=1 ; i<=N ; i++){
            num *= i;
            String sNum = num+"";
            while(sNum.charAt(sNum.length()-1) == '0') {
                num /= 10;
                sNum = num+"";
                cnt++;
            }
            if(num > 100){
                num = Integer.parseInt(sNum.substring(sNum.length()-3, sNum.length()));
            }
        }
        System.out.println(cnt);
    }
}
