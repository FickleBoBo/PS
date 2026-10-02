package day_16.BOJ_S5_2941;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = (sc.next()+"00").split("");    // 입력 받는데 인덱스 처리 고려해서 더미를 두 개 넣어줌
        int ans = input.length-2;                             // 더미 넣은만큼 빼줌

        // 무지성 조건문 on
        for(int i=0 ; i<input.length ; i++){
            if(input[i].equals("c") && ((input[i+1].equals("=") || input[i+1].equals("-")))){
                ans--;
            }
            else if(input[i].equals("d") && (((input[i+1].equals("z") && input[i+2].equals("=")) || input[i+1].equals("-")))){
                ans--;
            }
            else if(input[i].equals("l") && input[i+1].equals("j")){
                ans--;
            }
            else if(input[i].equals("n") && input[i+1].equals("j")){
                ans--;
            }
            else if(input[i].equals("s") && input[i+1].equals("=")){
                ans--;
            }
            else if(input[i].equals("z") && input[i+1].equals("=")){
                ans--;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
