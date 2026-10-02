package day_17.BOJ_G2_12100_Fail;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] map;
    static int[][] copyMap;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

//        int ans = 0;
//        char[] command = {'U', 'D', 'L', 'R'};
//        for (int a = 0; a < 4; a++) {
//            for (int b = 0; b < 4; b++) {
//                for (int c = 0; c < 4; c++) {
//                    for (int d = 0; d < 4; d++) {
//                        for (int e = 0; e < 4; e++) {
//                            copyOriginMap();
//                            char[] permutation = {command[a], command[b], command[c], command[d], command[e]};
//                            int result = play2048Game(permutation);
//                            ans = Math.max(ans, result);
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(ans);
//        sc.close();
    }

//    private static void copyOriginMap() {
//        for (int i = 0; i < N; i++) {
//            copyMap[i] = Arrays.copyOf(map[i], N);
//        }
//    }

//    private static int play2048Game(char[] arr) {
//        for(int i=0 ; i<5 ; i++){
//            if(arr[i] == 'U'){
//
//            }
//            else if(arr[i] == 'D'){
//
//            }
//            else if(arr[i] == 'L'){
//
//            }
//            else if(arr[i] == 'R'){
//
//            }
//        }
//    }

}
