package day_31.BOJ_G1_15644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[] arr = {'U', 'D', 'L', 'R'};
    static char[] sel = new char[10];

    static int N;
    static int M;
    static String[][] map;
    static int[] redPos;
    static int[] bluePos;

    static boolean flag = false;
    static int ans = Integer.MAX_VALUE;
    static char[] ansArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        redPos = new int[2];
        bluePos = new int[2];

        map = new String[N][M];
        for(int i=0 ; i<N ; i++){
            map[i] = br.readLine().split("");
            for(int j=0 ; j<M ; j++){
                if(map[i][j].equals("R")){
                    redPos[0] = i;
                    redPos[1] = j;
                }
                else if(map[i][j].equals("B")){
                    bluePos[0] = i;
                    bluePos[1] = j;
                }
            }
        }

        combination(0, -1);

        if(flag){
            System.out.println(ans);
            for(char c : ansArr){
                System.out.print(c);
            }
        }
        else System.out.println(-1);
    }

    private static void combination(int sidx, int pick){
        if(sidx == 10){
            moveBoard();
            return;
        }

        for(int i=0 ; i<4 ; i++){
            if(pick != i){
                sel[sidx] = arr[i];
                combination(sidx + 1, i);
            }
        }
    }

    private static void moveBoard(){
        String[][] copyMap = map.clone();
        for(int i=0 ; i<N ; i++){
            copyMap[i] = map[i].clone();
        }

        int rx = redPos[0];
        int ry = redPos[1];
        int bx = bluePos[0];
        int by = bluePos[1];

        boolean redout = false;
        boolean blueout = false;

        for(int i=0 ; i<10 ; i++){
            if(sel[i] == 'U'){
                if(rx < bx){
                    copyMap[rx][ry] = ".";
                    while(copyMap[rx-1][ry].equals(".")){
                        rx--;
                    }
                    if(copyMap[rx-1][ry].equals("O")) redout = true;
                    else copyMap[rx][ry] = "R";

                    copyMap[bx][by] = ".";
                    while(copyMap[bx-1][by].equals(".")){
                        bx--;
                    }
                    if(copyMap[bx-1][by].equals("O")) blueout = true;
                    else copyMap[bx][by] = "B";
                }
                else{
                    copyMap[bx][by] = ".";
                    while(copyMap[bx-1][by].equals(".")){
                        bx--;
                    }
                    if(copyMap[bx-1][by].equals("O")) blueout = true;
                    else copyMap[bx][by] = "B";

                    copyMap[rx][ry] = ".";
                    while(copyMap[rx-1][ry].equals(".")){
                        rx--;
                    }
                    if(copyMap[rx-1][ry].equals("O")) redout = true;
                    else copyMap[rx][ry] = "R";
                }
            }
            else if(sel[i] == 'D'){
                if(rx > bx){
                    copyMap[rx][ry] = ".";
                    while(copyMap[rx+1][ry].equals(".")){
                        rx++;
                    }
                    if(copyMap[rx+1][ry].equals("O")) redout = true;
                    else copyMap[rx][ry] = "R";

                    copyMap[bx][by] = ".";
                    while(copyMap[bx+1][by].equals(".")){
                        bx++;
                    }
                    if(copyMap[bx+1][by].equals("O")) blueout = true;
                    else copyMap[bx][by] = "B";
                }
                else{
                    copyMap[bx][by] = ".";
                    while(copyMap[bx+1][by].equals(".")){
                        bx++;
                    }
                    if(copyMap[bx+1][by].equals("O")) blueout = true;
                    else copyMap[bx][by] = "B";

                    copyMap[rx][ry] = ".";
                    while(copyMap[rx+1][ry].equals(".")){
                        rx++;
                    }
                    if(copyMap[rx+1][ry].equals("O")) redout = true;
                    else copyMap[rx][ry] = "R";
                }
            }
            else if(sel[i] == 'L'){
                if(ry < by){
                    copyMap[rx][ry] = ".";
                    while(copyMap[rx][ry-1].equals(".")){
                        ry--;
                    }
                    if(copyMap[rx][ry-1].equals("O")) redout = true;
                    else copyMap[rx][ry] = "R";

                    copyMap[bx][by] = ".";
                    while(copyMap[bx][by-1].equals(".")){
                        by--;
                    }
                    if(copyMap[bx][by-1].equals("O")) blueout = true;
                    else copyMap[bx][by] = "B";
                }
                else{
                    copyMap[bx][by] = ".";
                    while(copyMap[bx][by-1].equals(".")){
                        by--;
                    }
                    if(copyMap[bx][by-1].equals("O")) blueout = true;
                    else copyMap[bx][by] = "B";

                    copyMap[rx][ry] = ".";
                    while(copyMap[rx][ry-1].equals(".")){
                        ry--;
                    }
                    if(copyMap[rx][ry-1].equals("O")) redout = true;
                    else copyMap[rx][ry] = "R";
                }
            }
            else if(sel[i] == 'R'){
                if(ry > by){
                    copyMap[rx][ry] = ".";
                    while(copyMap[rx][ry+1].equals(".")){
                        ry++;
                    }
                    if(copyMap[rx][ry+1].equals("O")) redout = true;
                    else copyMap[rx][ry] = "R";

                    copyMap[bx][by] = ".";
                    while(copyMap[bx][by+1].equals(".")){
                        by++;
                    }
                    if(copyMap[bx][by+1].equals("O")) blueout = true;
                    else copyMap[bx][by] = "B";
                }
                else{
                    copyMap[bx][by] = ".";
                    while(copyMap[bx][by+1].equals(".")){
                        by++;
                    }
                    if(copyMap[bx][by+1].equals("O")) blueout = true;
                    else copyMap[bx][by] = "B";

                    copyMap[rx][ry] = ".";
                    while(copyMap[rx][ry+1].equals(".")){
                        ry++;
                    }
                    if(copyMap[rx][ry+1].equals("O")) redout = true;
                    else copyMap[rx][ry] = "R";
                }
            }

            if(redout && !blueout){
                flag = true;
                if(i+1 < ans){
                    ans = i + 1;
                    ansArr = new char[ans];
                    for(int j=0 ; j<ans ; j++){
                        ansArr[j] = sel[j];
                    }
                }
                return;
            }
        }
    }

}
