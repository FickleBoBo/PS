package day_29.BOJ_S1_1991;

import java.util.Scanner;

public class Main {

    static int N;
    static String[][] tree;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new String[N][3];

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<3 ; j++){
                tree[i][j] = sc.next();
            }
        }

        print1(0); System.out.println();
        print2(0); System.out.println();
        print3(0); System.out.println();
    }

    static void print1(int node){
        int left = -1;
        int right = -1;
        for(int i=0 ; i<N ; i++){
            if(tree[node][1].equals(tree[i][0])) left = i;
            if(tree[node][2].equals(tree[i][0])) right = i;
        }

        System.out.print(tree[node][0]);
        if(left>0) print1(left);
        if(right>0) print1(right);
    }

    static void print2(int node){
        int left = -1;
        int right = -1;
        for(int i=0 ; i<N ; i++){
            if(tree[node][1].equals(tree[i][0])) left = i;
            if(tree[node][2].equals(tree[i][0])) right = i;
        }

        if(left>0) print2(left);
        System.out.print(tree[node][0]);
        if(right>0) print2(right);
    }

    static void print3(int node){
        int left = -1;
        int right = -1;
        for(int i=0 ; i<N ; i++){
            if(tree[node][1].equals(tree[i][0])) left = i;
            if(tree[node][2].equals(tree[i][0])) right = i;
        }

        if(left>0) print3(left);
        if(right>0) print3(right);
        System.out.print(tree[node][0]);
    }

}
