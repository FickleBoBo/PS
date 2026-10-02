package day_27.BOJ_G5_2166_Fail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] pos = new int[N][2];
        for(int i=0 ; i<N ; i++){
            pos[i][0] = sc.nextInt();
            pos[i][1] = sc.nextInt();
        }

        double[] lens = new double[N-2];
        for(int i=1 ; i<N-1 ; i++){
            lens[i-1] = Dist(pos[i][0], pos[i][1], pos[i+1][0], pos[i+1][1]);
        }

        double[] cross = new double[N-1];
        for(int i=1 ; i<N ; i++){
            cross[i-1] = Dist(pos[0][0], pos[0][1], pos[i][0], pos[i][1]);
        }

        double ans = 0;
        for(int i=0 ; i<N-2 ; i++){
            ans += Heron(cross[i], cross[i+1], lens[i]);
//            System.out.println(ans);
        }

//        System.out.println(Arrays.toString(lens));
//        System.out.println(Arrays.toString(cross));

        System.out.printf("%.1f\n", ans);

        sc.close();
    }

    private static double Dist(int x1, int y1, int x2, int y2){
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx*dx + dy*dy);
    }

    private static double Heron(double a, double b, double c){
        double S = (a + b + c) / 2;
        return Math.sqrt(S * (S-a) * (S-b) * (S-c));
    }

}
