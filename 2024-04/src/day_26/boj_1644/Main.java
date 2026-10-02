package day_26.BOJ_G3_1644;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N==1) System.out.println(0);
        else{
            List<Integer> isPrime = new ArrayList<>();

            out:
            for(int i=2 ; i<=N ; i++){
                for(int j=2 ; j<=Math.sqrt(i) ; j++){
                    if(i % j == 0){
                        continue out;
                    }
                }
                isPrime.add(i);
            }

            int cnt = 0;
            int start = 0;
            int end = 0;
            int sum = isPrime.get(0);

            while(true){
                if(end == isPrime.size()-1){
                    if(sum < N){
                        break;
                    }
                    else if(sum == N){
                        cnt++;
                        break;
                    }
                }

                if(sum < N){
                    sum += isPrime.get(++end);
                }
                else if(sum > N){
                    sum -= isPrime.get(start++);
                }
                else{
//                for(int n : isPrime){
//                    System.out.print(n + " ");
//                }
//                System.out.println();
//                System.out.println(start + " " + end);
                    cnt++;
                    sum += isPrime.get(++end);
                    sum -= isPrime.get(start++);
                }
            }

            System.out.println(cnt);
        }

    }
}
