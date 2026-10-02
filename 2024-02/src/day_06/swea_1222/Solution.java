package day_06.SWEA_D4_1222;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int tc=1 ; tc<=10 ; tc++){          // tc : 각각의 테스트 케이스
            int N = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();         // str : 분해할 문자열
            String postfix = "";                // postfix : 후위 연산용으로 저장할 문자열
            CharStack st = new CharStack(N);    // char[] 배열로 구현한 스택 사용

            for(int i=0 ; i<N ; i++){
                if(('0'<=str.charAt(i)) && (str.charAt(i))<='9'){    // 숫자면
                    postfix += str.charAt(i);
                }
                else{
                    if(st.isEmpty()){    // + 일때 스택이 비었으면 푸시
                        st.push(str.charAt(i));
                    }
                    else{    // 스택이 안비었으면 팝하고 푸시 -> 그냥 바로 postfix로 넣어도 상관없을듯
                        postfix += st.pop();
                        st.push(str.charAt(i));
                    }
                }
            }
            while(!st.isEmpty()){    // 스택에 남은 찌꺼기 옮기기
                postfix += st.pop();
            }

            IntStack st2 = new IntStack(N);

            for(int i=0 ; i<N ; i++){
                if(('0'<=postfix.charAt(i)) && (postfix.charAt(i))<='9'){
                    st2.push(Character.getNumericValue(postfix.charAt(i)));    // char형 숫자를 보이는 그대로 int형으로 바꾸기
                }
                else{
                    int tmp2 = st2.pop();
                    int tmp1 = st2.pop();
                    int tmp = tmp1 + tmp2;
                    st2.push(tmp);
                }
            }

            int ans = st2.pop();

            System.out.printf("#%d %d\n", tc, ans);
        }

    }
}

class CharStack{

    // 멤버 변수
    char[] stack;
    int top;

    // 생성자
    CharStack(){}

    CharStack(int len){
        this();
        this.stack = new char[len];
        this.top = -1;
    }

    // 멤버 메서드

    // peek
    char peek(){
        return stack[top];
    }

    // push
    void push(char c){
        stack[++top] = c;
    }

    // pop
    char pop(){
        return stack[top--];
    }

    // isEmpty
    boolean isEmpty(){
        return top == -1;
    }

}

class IntStack{

    // 멤버 변수
    int[] stack;
    int top;

    // 생성자
    IntStack(){}

    IntStack(int len){
        this();
        this.stack = new int[len];
        this.top = -1;
    }

    // 멤버 메서드

    // peek
    int peek(){
        return stack[top];
    }

    // push
    void push(int i){
        stack[++top] = i;
    }

    // pop
    int pop(){
        return stack[top--];
    }

    // isEmpty
    boolean isEmpty(){
        return top == -1;
    }

}