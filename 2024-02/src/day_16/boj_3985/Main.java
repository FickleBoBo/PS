package day_16.BOJ_B1_3985;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int getMax = 0;        // 가장 많이 받은 롤케이크 길이
    static int getMaxIdx = 0;     // 가장 롤케이크를 많이 받은 사람
    static int maxDiff = 0;       // 가장 많이 받을 것으로 예상된 롤케이크 길이
    static int maxDiffIdx = 0;    // 가장 롤케이크를 많이 받을 것으로 예상된 사람

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] L = new int[sc.nextInt()+1];    // 롤케이크 배열
        int N = sc.nextInt();                 // 사람 수
        int[] cntArr = new int[N+1];          // 한 사람이 받은 롤케이크 수 저장 배열

        Stack<Integer> st = new Stack<>();    // 시작과 끝을 스택으로 받아서 팝을 통해 마지막 사람부터 덮어씌우기 함
        for(int i=0 ; i< 2* N ; i++){
            st.push(sc.nextInt());
        }

        while(!(st.isEmpty())){
            int end = st.pop();
            int start = st.pop();
            if(end-start >= maxDiff){
                maxDiff = end - start;
                maxDiffIdx = N;
            }
            for(int i=start ; i<=end ; i++){    // 롤케이크에 역순으로 값을 덮어씌움
                L[i] = N;
            }
            N--;
        }

        for(int i=1 ; i<L.length ; i++){    // 카운팅 배열에 저장
            cntArr[L[i]]++;
        }

        for(int i=cntArr.length-1 ; i>0 ; i--){    // for문 역순으로 돌아야 중복일 때 최소 번호가 나옴
            if(cntArr[i] >= getMax){
                getMax = cntArr[i];
                getMaxIdx = i;
            }
        }

        System.out.println(maxDiffIdx);
        System.out.println(getMaxIdx);
        sc.close();
    }
}
