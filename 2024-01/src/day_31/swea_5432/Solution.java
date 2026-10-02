package day_31.SWEA_D4_5432;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {	
	
    static Stack<Integer> st = new Stack<Integer>();
    static Stack<Integer> laser = new Stack<Integer>();
	
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));    // 이거라도 해야 시간 줄일거 같았음
        int T = Integer.parseInt(bf.readLine());

        for(int tc=1 ; tc<=T ; tc++){

            char[] input = bf.readLine().toCharArray();    // string.split("")에서 바꾸니 시간 단축됨
            
            int[] pipe = new int[input.length];    // 쇠막대기를 담을 배열(카운팅 배열과 유사하게 사용)
            int cnt = 0;    // 절단 수

            for(int i=0 ; i<input.length ; i++){
                if(input[i]=='('){    // 열린 괄호면 스택에 푸시
                    st.push(i);
                } else{    // 닫힌 괄호일 때 쇠막대기인지 레이저인지 구분
                    if((i-st.peek())==1){    // 레이저일 때
                    	laser.push(st.pop());    // 레이저에 푸시
                    } else{    // 쇠막대기일 때
                        for(int j=st.pop() ; j<=i ; j++){    // 쇠막대기 배열 채워줌
                            pipe[j]++;
                        }
                        cnt++;    // 절단수 + 1 = 절단된 갯수이므로 이때 한번 더해줌
                    }
                }
            }
            
            while(!(laser.isEmpty())) {    // 레이저에서 하나씩 팝
            	cnt += pipe[laser.pop()];    // 카운팅 배열 개념이므로 인덱스로 접근해서 바로 갯수 셈
            }
            
            System.out.printf("#%d %d\n", tc, cnt);
        }
        bf.close();
    }
}