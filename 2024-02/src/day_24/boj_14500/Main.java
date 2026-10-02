package day_24.BOJ_G4_14500;

import java.util.Scanner;

public class Main {

    // 출력할 최댓값
    static int max = 0;

    // 배열을 시계방향으로 90도 회전시킨 배열을 리턴하는 메서드
    static int[][] turn90map(int[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        int[][] turnArr = new int[M][N];
        for(int i=0 ; i<M ; i++){
            for(int j=0 ; j<N ; j++){
                turnArr[i][j] = arr[N-j-1][i];
            }
        }
        return turnArr;
    }

    // 하늘색 테트로미노 완전탐색
    static void compareTetromino1(int[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M-3 ; j++){
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
                max = max > sum ? max : sum;
            }
        }
    }

    // 노란색 테트로미노 완전탐색
    static void compareTetromino2(int[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        for(int i=0 ; i<N-1 ; i++){
            for(int j=0 ; j<M-1 ; j++){
                int sum = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];
                max = max > sum ? max : sum;
            }
        }
    }

    // 주황색 테트로미노 완전탐색(뒤집기 고려해야함)
    static void compareTetromino3(int[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        for(int i=0 ; i<N-2 ; i++){
            for(int j=0 ; j<M-1 ; j++){
                int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
                int sumFlip = arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1] + arr[i+2][j];
                max = max > sum ? max : sum;
                max = max > sumFlip ? max : sumFlip;
            }
        }
    }

    // 연두색 테트로미노 완전탐색(뒤집기 고려해야함)
    static void compareTetromino4(int[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        for(int i=0 ; i<N-2 ; i++){
            for(int j=0 ; j<M-1 ; j++){
                int sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
                int sumFlip = arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j];
                max = max > sum ? max : sum;
                max = max > sumFlip ? max : sumFlip;
            }
        }
    }

    // 분홍색 테트로미노 완전탐색
    static void compareTetromino5(int[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        for(int i=0 ; i<N-1 ; i++){
            for(int j=0 ; j<M-2 ; j++){
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
                max = max > sum ? max : sum;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 입력 받기(기본 배열을 0도 회전했단 의미로 map0)
        int[][] map0 = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                map0[i][j] = sc.nextInt();
            }
        }

        // 90도씩 회전시킨 map을 만들고 테트로미노와 비교 예정
        int[][] map90 = turn90map(map0);
        int[][] map180 = turn90map(map90);
        int[][] map270 = turn90map(map180);

        // 무지성 비교 on
        compareTetromino1(map0);
        compareTetromino1(map90);
        compareTetromino1(map180);
        compareTetromino1(map270);

        compareTetromino2(map0);
        compareTetromino2(map90);
        compareTetromino2(map180);
        compareTetromino2(map270);

        compareTetromino3(map0);
        compareTetromino3(map90);
        compareTetromino3(map180);
        compareTetromino3(map270);

        compareTetromino4(map0);
        compareTetromino4(map90);
        compareTetromino4(map180);
        compareTetromino4(map270);

        compareTetromino5(map0);
        compareTetromino5(map90);
        compareTetromino5(map180);
        compareTetromino5(map270);

        System.out.println(max);

        sc.close();
    }
}
