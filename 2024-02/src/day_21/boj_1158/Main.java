package day_21.BOJ_S4_1158;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();                      // N : 사람 수
        List<Integer> list = new ArrayList<>();    // list : 어레이 리스트에 1 ~ N까지 받아놓고 인덱스 장난질 할 예정
        for(int i=1 ; i<=N ; i++){
            list.add(i);
        }

        int K = sc.nextInt()-1;    // K : K칸 부터 생각할건데 list에서는 인덱스로 get을 할거라 1을 빼준 값으로 초기화
        int term = K;              // term : 입력 받은 칸 다음 수를 세야하므로 임시 변수에 담아줌(사실상 상수)

        StringBuilder sb = new StringBuilder("<");    // sb : 출력이 더러워서 StringBuilder 하나 만듦

        for(int i=0 ; i<N ; i++){             // 사람 수만큼 돌 예정
            if(K >= list.size()){             // K가 어레이 리스트 크기를 넘어가면
                K %= list.size();             // list 길이로 나눈 나머지로 초기화(뺄셈하면 에러나는데 천천히 찾아보면 이유 나올듯)
            }
            sb.append(list.get(K) + ", ");    // (4, ) 이런식으로 찾은 값을 스트링빌더에 넣어줌
            list.remove(K);                   // 찾은 사람 번호는 리스트에서 지움
            K += term;                        // 다음 K번째를 찾음
        }
        String ans = sb.substring(0, sb.length()-2) + ">";    // ans : 출력 양식에 맞춰 억지 선언함

        System.out.println(ans);

        sc.close();
    }
}
