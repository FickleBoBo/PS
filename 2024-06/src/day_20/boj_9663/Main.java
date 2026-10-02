package day_20.BOJ_G4_9663;

import java.util.*;

public class Main {

    static int N;
    static int cnt = 0;
    static boolean[] visited;

    static Map<Integer, Boolean> diagonal = new HashMap<>();
    static Map<Integer, Boolean> antiDiagonal = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited = new boolean[N];

        permutation(0);

        System.out.println(cnt);
    }

    private static void permutation(int sidx) {
        if(sidx == N){
            cnt++;
            return;
        }

        for(int i=0 ; i<N ; i++){
            int digNum = sidx + i;
            int antiDigNum = sidx - i;

            if(!visited[i] &&
                    !diagonal.getOrDefault(digNum, false) &&
                    !antiDiagonal.getOrDefault(antiDigNum, false)){

                visited[i] = true;
                diagonal.put(digNum, true);
                antiDiagonal.put(antiDigNum, true);

                permutation(sidx+1);

                visited[i] = false;
                diagonal.put(digNum, false);
                antiDiagonal.put(antiDigNum, false);
            }
        }
    }

}
