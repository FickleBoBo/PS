package day_14.boj_4562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0 ; i<N ; i++){
            if(sc.nextInt() < sc.nextInt()){
                System.out.println("NO BRAINS");
            }
            else{
                System.out.println("MMM BRAINS");
            }
        }
    }
}
