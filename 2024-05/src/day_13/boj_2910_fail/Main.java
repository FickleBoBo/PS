package day_13.BOJ_S3_2910_Fail;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        int[] cntArr = new int[1+C];

        for(int i=0 ; i<N ; i++){
            int n = sc.nextInt();
            if(!list.contains(n)){
                list.add(n);
            }
            cntArr[n]++;
        }

        for(int i=0 ; i<list.size() ; i++){
            for(int j=0 ; j < cntArr[list.get(i)] ; j++){
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
