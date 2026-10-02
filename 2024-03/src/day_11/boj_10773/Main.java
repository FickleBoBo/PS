package day_11.BOJ_S4_10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int i=0 ; i<K ; i++){
            int n = sc.nextInt();
            if(n > 0){
                st.push(n);
                ans += n;
            }
            else{
                ans -= st.pop();
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
