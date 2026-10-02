package day_21.BOJ_S4_2567;

import java.util.Scanner;

public class Main {

    // 상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] table = new int[1+100+1][1+100+1];
        int N = sc.nextInt();

        // 색종이 일단 바르기
        for(int i=0 ; i<N ; i++){
            int row = sc.nextInt()+1;
            int col = sc.nextInt()+1;
            for(int j=col ; j<col+10 ; j++){
                for(int k=row ; k<row+10 ; k++){
                    table[j][k] = 1;
                }
            }
        }

        // 색종이가 붙은 칸에 왔을 때 사방탐색해서 색종이가 안 붙은 칸 있으면 길이 1 더해줌
        // 근데 반대로 빈칸 주변 사방 탐색에서 색종이 있을때 +1 하는 건 통과 안됨...??
        // 아마 table 끝에 걸칠때 조건 때문인듯(패딩으로 해소 덜됨)
        int len = 0;
        for(int i=1 ; i<=100 ; i++){
            for(int j=1 ; j<=100 ; j++){
                if(table[i][j]==1){
                    for(int k=0 ; k<4 ; k++){
                        if(table[i+dr[k]][j+dc[k]]==0){
                            len++;
                        }
                    }
                }
            }
        }

        System.out.println(len);

        sc.close();
    }
}
