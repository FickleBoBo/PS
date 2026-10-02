package day_06.SWEA_D4_1224;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
         
        // 1. 후위 연산으로 바꾸는 여정
        Map<Character, Integer> map = new HashMap<Character, Integer>();    // 키와 밸류로 연산자 우선순위를 설정해줌
        map.put('(', 0);
        map.put('+', 1);
        map.put('*', 2);
         
        Scanner sc = new Scanner(System.in);
         
        for(int tc=1 ; tc<=10 ; tc++) {         // 테스트 케이스만큼 반복
             
            int N = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();         // 계산할 수식 문자열
            String postfix = "";                // 후위연산으로 변환한 문자열
 
            CharStack st = new CharStack(N);    // char형 스택 선언
             
            for(int i=0 ; i<N ; i++) {
            	// 일단 숫자면 담아!
                if(('0'<=str.charAt(i)) && (str.charAt(i))<='9') {
                    postfix += str.charAt(i);
                }
                // 숫자가 아니면?
                else {
                	// 스택이 비었거나 ( 이면 푸시
                    if(st.isEmpty() || str.charAt(i)=='(') {
                        st.push(str.charAt(i));
                    }
                    // ) 만나면 ( 나올때까지 팝팝팝
                    else if(str.charAt(i)==')') {
                        while(st.peek() != '(') {
                            postfix += st.pop();
                        }
                        st.pop();
                    }
                    // + 나 * 라면
                    else {
                    	// ( 이거면 걍 푸시
                        if(st.peek()=='(') {
                            st.push(str.charAt(i));
                        }
                        // 우선순위가 맞으면 푸시
                        else if(map.get(st.peek()) < map.get(str.charAt(i))) {
                            st.push(str.charAt(i));
                        }
                        // 팝팝ㅍ밮밥팝
                        else {
                            while((!st.isEmpty()) && (map.get(st.peek()) >= map.get(str.charAt(i)))) {
                                postfix += st.pop();
                            }
                            st.push(str.charAt(i));
                        }
                    }
                }
            }
            // 남은 잔반 팝팝ㅍ밮바
            while(!st.isEmpty()) {
                postfix += st.pop();
            }
             
             
             
            // 2. 이제 계산할 차례
            IntStack st2 = new IntStack(N);
             
            for(int i=0 ; i<postfix.length() ; i++) {
                if('0'<=postfix.charAt(i) && postfix.charAt(i)<='9') {
                    st2.push(Character.getNumericValue(postfix.charAt(i)));
                }
                else {
                    int tmp2 = st2.pop();    // 뒤로 갈거라 먼저 팝인데 교환법칙돼서 큰 상관 없음
                    int tmp1 = st2.pop();
                     
                    if(postfix.charAt(i)=='+') {
                        int tmp = tmp1 + tmp2;
                        st2.push(tmp);
                    }
                    else if(postfix.charAt(i)=='*') {
                        int tmp = tmp1 * tmp2;
                        st2.push(tmp);
                    }
                }
            }
             
            System.out.printf("#%d %d\n", tc, st2.pop());
        }
        sc.close();
    }
}
 
class CharStack{
     
    // 멤버 변수
    int len = 0;
    char[] stack = new char[len];
    int top = -1;
     
    // 생성자
    public CharStack() {}
     
    public CharStack(int len) {
        this();
        this.len = len;
        this.stack = new char[len];
    }
     
    // 멤버 메서드
    public boolean isEmpty() {
        return top == -1;
    }
     
    public char peek() {
        return stack[top];
    }
     
    public void push(char c) {
        stack[++top] = c;
    }
     
    public char pop() {
        return stack[top--];
    }
     
}
 
class IntStack{
     
    // 멤버 변수
    int len = 0;
    int[] stack = new int[len];
    int top = -1;
     
    // 생성자
    public IntStack() {}
     
    public IntStack(int len) {
        this();
        this.len = len;
        this.stack = new int[len];
    }
     
    // 멤버 메서드
    public boolean isEmpty() {
        return top == -1;
    }
     
    public int peek() {
        return stack[top];
    }
     
    public void push(int c) {
        stack[++top] = c;
    }
     
    public int pop() {
        return stack[top--];
    }
     
}