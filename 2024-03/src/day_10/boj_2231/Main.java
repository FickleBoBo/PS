package day_10.BOJ_B2_2231;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean flag = false;
        int ans = 1;
        int tmp = ans;
        while(ans <= N){    // 처음부터 찾는데 N보다 커질때는 답이 될 수 없어서 종료
            char[] trans = (ans+"").toCharArray();
            for(int i=0 ; i<trans.length ; i++){
                tmp += Character.getNumericValue(trans[i]);
            }
            if(tmp == N){    // 생성자를 찾으면 flag 켜고(생성자 존재) 종료
                flag = true;
                break;
            }
            else{    // 아니면 1 더한 값으로 다시 탐색
                ans++;
                tmp = ans;
            }
        }

        if(flag){
            System.out.println(ans);
        }
        else{
            System.out.println(0);
        }

        sc.close();
    }
}
