package day_10.BOJ_G2_17387;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        for(int tc=1 ; tc<=18 ; tc++) {

        int[][] pos1 = new int[2][2];
        int[][] pos2 = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                pos1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                pos2[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(pos1, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));
        Arrays.sort(pos2, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));

        long x1 = pos1[0][0];
        long y1 = pos1[0][1];
        long x2 = pos1[1][0];
        long y2 = pos1[1][1];
        long x3 = pos2[0][0];
        long y3 = pos2[0][1];
        long x4 = pos2[1][0];
        long y4 = pos2[1][1];

        long dx1 = x2 - x1;
        long dy1 = y2 - y1;
        long dx2 = x4 - x3;
        long dy2 = y4 - y3;

        if (dy1==0 && dy2== 0) {
            if (y1 != y3) {
                System.out.println(0);
            } else {
                if (x1 > x4 || x2 < x3) System.out.println(0);
                else System.out.println(1);
            }
        }
        else if (dx1==0 && dx2==0) {
            if (x1 != x3) {
                System.out.println(0);
            } else {
                if (y1 > y4 || y2 < y3) System.out.println(0);
                else System.out.println(1);
            }
        }
        else if (dx1==0) {
//            long tmpY = dy2 * (x1-x3) + y3 * dx2;
            if (((dy2 * (x1-x3) + y3 * dx2) >= y3 * dx2 && (dy2 * (x1-x3) + y3 * dx2) <= y4 * dx2 || (dy2 * (x1-x3) + y3 * dx2) >= y4 * dx2 && (dy2 * (x1-x3) + y3 * dx2) <= y3 * dx2) &&
                    ((dy2 * (x1-x3) + y3 * dx2) >= y1 * dx2 && (dy2 * (x1-x3) + y3 * dx2) <= y2 * dx2 || (dy2 * (x1-x3) + y3 * dx2) >= y2 * dx2 && (dy2 * (x1-x3) + y3 * dx2) <= y1 * dx2) &&
                    (x1 >= x3 && x1 <= x4 || x1 >= x4 && x1 <= x3)) {
                System.out.println(1);
//                    System.out.println("여기?");
            } else {
                System.out.println(0);
//                    System.out.println("여기?");
            }
        }
        else if (dx2==0) {
//            long tmpY = dy1 * (x3-x1) + y1 * dx1;
//                System.out.println(tmpY);
//                System.out.println(y1*dx1);
//                System.out.println(y2*dx1);
            if (((dy1 * (x3-x1) + y1 * dx1) >= y1 * dx1 && (dy1 * (x3-x1) + y1 * dx1) <= y2 * dx1 || (dy1 * (x3-x1) + y1 * dx1) >= y2 * dx1 && (dy1 * (x3-x1) + y1 * dx1) <= y1 * dx1) &&
                    ((dy1 * (x3-x1) + y1 * dx1) >= y3 * dx1 && (dy1 * (x3-x1) + y1 * dx1) <= y4 * dx1 || (dy1 * (x3-x1) + y1 * dx1) >= y4 * dx1 && (dy1 * (x3-x1) + y1 * dx1) <= y3 * dx1) &&
                    ((x3 >= x1 && x3 <= x2 || x3 >= x2 && x3 <= x1))) {
                System.out.println(1);
            } else {
                System.out.println(0);
//                    System.out.println("여기?");
            }
        }
        else if (dy1 * dx2 == dy2 * dx1) {
            if (dy1 * dx2 * x1 - dx1 * dx2 * y1 != dy2 * dx1 * x3 - dx1 * dx2 * y3) {
                System.out.println(0);
//                System.out.println("여기?");
            } else {
                if (x1 > x4 || x2 < x3) {
                    System.out.println(0);
//                    System.out.println(y1);
//                    System.out.println(y2);
//                    System.out.println(y3);
//                    System.out.println(y4);
                } else {
                    System.out.println(1);
                }
            }
        } else {
//                double x = (m1 * x1 + m2 * x3 - y1 + y3) / (m1 - m2);
//                long x = (y3-y1)*dx1*dx2+(dx2*dy1*x1-dx1*dy2*x3);
//                System.out.println(x);
//                long dummy = dx2*dy1 - dx1*dy2;
//                System.out.println(dummy);
//                System.out.println(x1*dummy);
//                System.out.println(x2*dummy);
//                System.out.println(x3*dummy);
//                System.out.println(x4*dummy);
//            System.out.println((y3-y1)*dx1*dx2+(dx2*dy1*x1-dx1*dy2*x3));
            if (((y3-y1)*dx1*dx2+(dx2*dy1*x1-dx1*dy2*x3) >= x1*(dx2*dy1 - dx1*dy2) && (y3-y1)*dx1*dx2+(dx2*dy1*x1-dx1*dy2*x3) <= x2*(dx2*dy1 - dx1*dy2) || (y3-y1)*dx1*dx2+(dx2*dy1*x1-dx1*dy2*x3) >= x2*(dx2*dy1 - dx1*dy2) && (y3-y1)*dx1*dx2+(dx2*dy1*x1-dx1*dy2*x3) <= x1*(dx2*dy1 - dx1*dy2)) &&
                    (y3-y1)*dx1*dx2+(dx2*dy1*x1-dx1*dy2*x3) >= x3*(dx2*dy1 - dx1*dy2) && (y3-y1)*dx1*dx2+(dx2*dy1*x1-dx1*dy2*x3) <= x4*(dx2*dy1 - dx1*dy2) || (y3-y1)*dx1*dx2+(dx2*dy1*x1-dx1*dy2*x3) >= x4*(dx2*dy1 - dx1*dy2) && (y3-y1)*dx1*dx2+(dx2*dy1*x1-dx1*dy2*x3) <= x3*(dx2*dy1 - dx1*dy2)) {
                System.out.println(1);
            } else {
                System.out.println(0);
//                    System.out.println("여기?");
            }
        }
//        }
    }
}
