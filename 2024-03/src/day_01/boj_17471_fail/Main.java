package day_01.BOJ_G4_17471_Fail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];
        int[][] matrix = new int[N][N];

        for(int i=0 ; i<N ; i++){
            nums[i] = sc.nextInt();
        }
        sc.nextLine();

        for(int i=0 ; i<N ; i++){
            String[] input = sc.nextLine().split(" ");
            for(int j=1 ; j<input.length ; j++){
                matrix[i][Integer.parseInt(input[j])-1] = 1;
            }
        }

//        for(int i=0 ; i<N ; i++){
//            for(int j=0 ; j<N ; j++){
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        sc.close();
    }

    static boolean isConnected(int[] arr, int[][] connection){
        for(int i=0 ; i<arr.length ; i++){
            int cnt = 0;
            for(int j=0 ; j<arr.length ; j++){
                if((i != j) && (connection[arr[i]][arr[j]] == 1)){
                    cnt++;
                }
            }
            if(cnt == 0) return false;
        }
        return true;
    }

}
