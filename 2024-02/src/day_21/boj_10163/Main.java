package day_21.BOJ_B1_10163;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        int[][] table = new int[1001][1001];
        int[][] rec = new int[N][4];
        for(int i=0 ; i<N ; i++){
            rec[i][0] = sc.nextInt();
            rec[i][1] = sc.nextInt();
            rec[i][2] = sc.nextInt();
            rec[i][3] = sc.nextInt();
        }

        // 배열에 덮어씌우며 채우기
        // i는 직사각형별로 순회
        // j, k는 각각의 직사각형 배열을 순회
        for(int i=0 ; i<N ; i++){
            for(int j=rec[i][0] ; j<rec[i][0]+rec[i][2] ; j++){
                for(int k=rec[i][1] ; k<rec[i][1]+rec[i][3] ; k++){
                    table[j][k] = i+1;
                }
            }
        }

        // 카운팅 배열로 세기
        int[] countingArr = new int[N+1];
        for(int i=0 ; i<1001 ; i++){
            for(int j=0 ; j<1001 ; j++){
                countingArr[table[i][j]]++;
            }
        }

        for(int i=1 ; i<=N ; i++){
            System.out.println(countingArr[i]);
        }
        sc.close();
    }
}
