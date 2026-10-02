package day_03.BOJ_S5_5635;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[][] arr = new String[n][4];
        for(int i=0 ; i<n ; i++){
            arr[i][0] = sc.next();
            arr[i][1] = sc.nextInt()+"";
            arr[i][2] = sc.nextInt()+"";
            arr[i][3] = sc.nextInt()+"";
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if(Integer.parseInt(o1[3])==Integer.parseInt(o2[3])){
                if(Integer.parseInt(o1[2])==Integer.parseInt(o2[2])){
                    return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
                }
                return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]);
            }
            return Integer.parseInt(o1[3])-Integer.parseInt(o2[3]);
        }));

        System.out.println(arr[n-1][0]);
        System.out.println(arr[0][0]);
    }
}
