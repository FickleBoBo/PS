package day_19.BOJ_B1_2851;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ans = 0;                                 // ans : 마리오가 받은 점수의 합

        for(int i=0 ; i<10 ; i++){
            int num = sc.nextInt();                  // num : 하나 입력 받아서 저장

            if(ans+num >= 100){                      // 다음 버섯을 먹었을 때, 점수가 100점 이상이면
                int gap1 = Math.abs(ans+num-100);    // 먹은 후 점수와 100점과의 차이
                int gap2 = Math.abs(100-ans);        // 먹기 전 점수와 100점과의 차이

                if(gap1 <= gap2){                    // 먹은 후 점수와 100점과의 차이가 작거나 같으면
                    ans += num;                      // 먹고 break
                }
                break;
            }
            ans += num;                              // 다음 버섯을 먹어도 100점 미만이면 계속 먹음
        }
        System.out.println(ans);
        sc.close();
    }
}
