package day_01.SWEA_모의SW역량테스트_5656;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int N;
    static int W;
    static int H;
    static int[][] map;
    static int[][] copyMap;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int ans;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            N = sc.nextInt();
            W = sc.nextInt();
            H = sc.nextInt();
            map = new int[H][W];
            for(int h=0 ; h<H ; h++){
                for(int w=0 ; w<W ; w++){
                    map[h][w] = sc.nextInt();
                }
            }
            ans = Integer.MAX_VALUE;

            int[] dropCols;

            if(N == 1){
                for(int a=0 ; a<W ; a++){
                    dropCols = new int[]{a};
                    dropBalls(dropCols);
                }
            }
            else if(N == 2){
                for(int a=0 ; a<W ; a++){
                    for(int b=0 ; b<W ; b++){
                        dropCols = new int[]{a, b};
                        dropBalls(dropCols);
                    }
                }
            }
            else if(N == 3){
                for(int a=0 ; a<W ; a++){
                    for(int b=0 ; b<W ; b++){
                        for(int c=0 ; c<W ; c++){
                            dropCols = new int[]{a, b, c};
                            dropBalls(dropCols);
                        }
                    }
                }
            }
            else if(N == 4){
                for(int a=0 ; a<W ; a++){
                    for(int b=0 ; b<W ; b++){
                        for(int c=0 ; c<W ; c++){
                            for(int d=0 ; d<W ; d++){
                                dropCols = new int[]{a, b, c, d};
                                dropBalls(dropCols);
                            }
                        }
                    }
                }
            }

//            printMap();
            System.out.printf("#%d %d\n", tc, ans);

        }
        sc.close();
    }

    static void printCopyMap(){
        for(int h=0 ; h<H ; h++){
            for(int w=0 ; w<W ; w++){
                System.out.print(copyMap[h][w] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void copyOriginMap(){
        copyMap = new int[H][W];
        for(int h=0 ; h<H ; h++){
            copyMap[h] = Arrays.copyOf(map[h], W);
        }
    }

    static void dropBalls(int[] dropCols) {
        copyOriginMap();

        for(int i=0 ; i<dropCols.length ; i++){
            for(int h=0 ; h<H ; h++){
                if(copyMap[h][dropCols[i]] != 0){
//                    System.out.println(Arrays.toString(dropCols));
//                    System.out.println("떨어뜨린 위치: " + h + " " + dropCols[i]);
                    boomBlock(h, dropCols[i], copyMap[h][dropCols[i]]);
//                    printCopyMap();
                    dropBlocks();
//                    printCopyMap();
                    break;
                }
            }
        }

        int cnt = 0;
        for(int a=0 ; a<H ; a++){
            for(int b=0 ; b<W ; b++){
                if(copyMap[a][b] != 0) cnt++;
            }
        }
        ans = ans > cnt ? cnt : ans;

    }

    static void dropBlocks() {
        for(int i=0 ; i<W ; i++){
            for(int j=1 ; j<H ; j++){
                if((j > 0) && (copyMap[H-j-1][i] != 0) && (copyMap[H-j][i] == 0)){
                    copyMap[H-j][i] = copyMap[H-j-1][i];
                    copyMap[H-j-1][i] = 0;
                    j -= 2;
                }
            }
        }
    }

    static void boomBlock(int row, int col, int length) {
        if(copyMap[row][col] == 0) return;
        copyMap[row][col] = 0;

        for(int len=1 ; len<length ; len++){
            for(int dir=0 ; dir<4 ; dir++){
                int nr = row+dr[dir]*len;
                int nc = col+dc[dir]*len;
                if((nr>=0) && (nc>=0) && (nr<H) && (nc<W)){
                    boomBlock(nr, nc, copyMap[nr][nc]);

                }
            }
        }

    }

}
