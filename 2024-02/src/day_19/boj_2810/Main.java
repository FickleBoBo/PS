package day_19.BOJ_B1_2810;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                          // N : 좌석의 수
        String[] seats = sc.next().split("");    // seats : 일반 좌석은 S, 커플 좌석은 L로 쪼개서 받음

        int cnt = 1;                     // cnt : 컵홀더의 수(맨 앞에 일단 컵홀더 하나라서 +1)
        for(int i=0 ; i<N ; i++){
            if(seats[i].equals("S")){    // 일반 좌석이면 컵홀더 개수 +1
                cnt++;
            }
            else{                        // 커플 좌석이면 컵홀더 개수 +1 하고 오른쪽 커플 좌석은 i++로 건너뜀
                cnt++;
                i++;
            }
        }

        System.out.println(Math.min(N, cnt));    // 사람 수와 컵홀더의 수 중 최솟값이 컵홀더를 사용하는 사람 수

        sc.close();
    }
}
