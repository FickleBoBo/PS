package day_21.BOJ_B2_13300;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner((System.in));

        int N = sc.nextInt();           // N : 총 학생 수
        int K = sc.nextInt();           // K : 한 방에 들어갈 수 있는 학생 수
        int[] male = new int[6+1];      // index 학년별 남학생 수
        int[] female = new int[6+1];    // index 학년별 남학생 수

        for(int i=0 ; i<N; i++){          // 카운팅 배열 돌리기
            int gender = sc.nextInt();    // gender : 성별
            int grade = sc.nextInt();     // grade : 학년
            if(gender==1){
                male[grade]++;
            }
            else{
                female[grade]++;
            }
        }

        int room = 0;    // room : 필요한 방 개수
        for(int i=1 ; i<=6 ; i++){
            if(male[i]%K == 0){         // 남학생에 대해서 방에 딱 들어가면
                room += male[i] / K;    // 몫을 더해줌
            }
            else{
                room += male[i] / K + 1;    // 딱 안들어가면 방 하나 추가
            }
            if(female[i]%K == 0){         // 여학생에 대해서 방에 딱 들어가면
                room += female[i] / K;    // 몫을 더해줌
            }
            else{
                room += female[i] / K + 1;    // 딱 안들어가면 방 하나 추가
            }
        }

        System.out.println(room);

        sc.close();
    }
}
