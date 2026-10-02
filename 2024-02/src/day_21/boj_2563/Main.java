package day_21.BOJ_S5_2563;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] table = new int[100][100];
        int N = sc.nextInt();

        // 입력 받은 색종이 스펙에 맞게 1로 바꿔줌
        for(int i=0 ; i<N ; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            for(int j=col ; j<col+10 ; j++){
                for(int k=row ; k<row+10 ; k++){
                    table[j][k] = 1;
                }
            }
        }

        // 1로 바뀐거 싹 더함
        int cnt = 0;
        for(int i=0 ; i<100 ; i++){
            for(int j=0 ; j<100 ; j++){
                if(table[i][j] != 0){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        sc.close();
    }
}
