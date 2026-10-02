package day_18.SWEA_D3_5356;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1 ; tc<=T ; tc++){
            Queue<String> queue = new LinkedList<String>();

            String[][] table = new String[5][];
            int maxCol = 0;
            for(int i=0 ; i<5 ; i++){
                table[i] = sc.next().split("");
                maxCol = Math.max(maxCol, table[i].length);
            }

            for(int c=0 ; c<maxCol ; c++){
                for(int r=0 ; r<5 ; r++){
                    if(table[r].length > c){
                        queue.offer(table[r][c]);
                    }
                }
            }

            System.out.printf("#%d ", tc);
            while(!(queue.isEmpty())){
                System.out.print(queue.poll());
            }
            System.out.println();
        }
        sc.close();
    }
}
