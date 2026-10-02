package day_23.BOJ_G5_14891;

import java.util.Scanner;

public class Main {
    // 구현이 상당히 까다로웠고 디버깅이 많이 어려웠다

    // 4개의 톱니바퀴의 정보를 담을 2차원 배열
    static String[][] gear = new String[4][8];

    // 각각의 톱니바퀴의 12시(정답 판별), 9시(왼쪽 닿는 부분), 3시(오른쪽 닿는 부분) 인덱스를 담을 2차원 배열
    static int[][] gearIdx = {
            {0, 6, 2},
            {0, 6, 2},
            {0, 6, 2},
            {0, 6, 2},
    };

    // N번 톱니바퀴를 회전하고 인덱스를 갱신하는 메서드
    static void spinGear(int N, int turn){
        for(int i=0 ; i<3 ; i++){
            gearIdx[N][i] -= turn;    // 뺄셈을 해야함
        }
        for(int i=0 ; i<4 ; i++){
            for(int j=0 ; j<3 ; j++){
                gearIdx[i][j] = (gearIdx[i][j]+8) % 8;    // 이렇게하면 음수가 될 때랑 배열길이를 넘어갈 때 둘다 커버 가능
            }
        }
    }

    // N번 톱니바퀴를 돌릴 때 돌아가야하는 기어들을 불린 배열에 담아서 리턴(true면 돌려야 하는 기어임을 의미)
    static boolean[] chooseGears(int N){
        boolean[] arr = new boolean[4];
        arr[N] = true;    // N번 톱니바퀴는 무조건 돌리므로 true 할당

        // N번 톱니바퀴의 왼쪽 톱니바퀴들을 비교해나감
        for(int i=N ; i>0 ; i--){
            if(gear[i][gearIdx[i][1]].equals(gear[i-1][gearIdx[i-1][2]])){    // 하 여기서 i 대신에 N을 써서 디버깅만 1시간한듯
                break;
            }
            else{
                arr[i-1] = true;
            }
        }

        // N번 톱니바퀴의 오른쪽 톱니바퀴들을 비교해나감
        for(int i=N ; i<3 ; i++){
            if(gear[i][gearIdx[i][2]].equals(gear[i+1][gearIdx[i+1][1]])){
                break;
            }
            else{
                arr[i+1] = true;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 그냥 스트링 2차원으로 받았음
        for(int i=0 ; i<4 ; i++){
            gear[i] = sc.next().split("");
        }

        int K = sc.nextInt();

        for(int i=0 ; i<K ; i++){
            int N = sc.nextInt();
            int turn = sc.nextInt();

            // 주어진 톱니바퀴에 대해 돌아가야하는 톱니바퀴들을 받음(인덱스땜에 N-1을 파라미터로 전함)
            boolean[] tmp = chooseGears(N-1);
            int[] dir;    // 톱니바퀴가 어떻게 회전할지 고르려고 선언만 하고 이후 할당해줌
            int[] dir1 = {1, -1, 1, -1};
            int[] dir2 = {-1, 1, -1, 1};
            if(dir1[N-1]==turn){
                dir = dir1;
            }
            else{
                dir = dir2;
            }

            for(int j=0 ; j<4 ; j++){    // 각각의 톱니바퀴에 대해서
                if(tmp[j]){    // true라 돌려줘야하는 톱니바퀴면
                    spinGear(j, dir[j]);    // 돌려
                }
            }
        }

        // 이 모든과정을 끝내면 이제 12시 톱니가 S인지 판단
        int ans = 0;
        if(gear[0][gearIdx[0][0]].equals("1")){
            ans += 1;
        }
        if(gear[1][gearIdx[1][0]].equals("1")){
            ans += 2;
        }
        if(gear[2][gearIdx[2][0]].equals("1")){
            ans += 4;
        }
        if(gear[3][gearIdx[3][0]].equals("1")){
            ans += 8;
        }

        System.out.println(ans);

        sc.close();
    }
}
