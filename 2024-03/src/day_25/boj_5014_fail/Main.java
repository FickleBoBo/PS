package day_25.BOJ_S1_5014_Fail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();

        boolean flag = false;
        int ans = 0;
        int move = 0;

        if(((G > S) && (U == 0)) || (G < S) && (D == 0)){
            flag = true;
        }
        else{
            if(G > S){
                while(G > S-U){
                    S += U;
                    move++;
                }
            }
            else if(G < S){
                while(G < S+D){
                    S -= D;
                    move++;
                }
            }
        }

        if(flag) System.out.println("use the stairs");
        else System.out.println(ans);

        sc.close();
    }

}
