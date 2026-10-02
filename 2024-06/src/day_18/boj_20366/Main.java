package day_18.BOJ_G3_20366;

import java.io.*;
import java.util.*;

/*
 * N이 최대 600이어서 가능한 눈사람 조합은 대충 18000개? 예상
 * 18000개를 이중 for문 돌면 대충 4억정도 되니까 안될거 같았음(대충 1초에 1억?)
 *
 * 우선순위 큐 두 개 만들어서 list 각각 넣고 비교하면서 찾으려 했는데 잘 안됨
 * (암만 봐도 완탐 같은데라는 느낌이 딱 듦 + N<=600 인게 완탐이라는 힌트인가 싶음)
 *
 * 근데 또 정렬을 하고 이중 for문 돌면 break 잘 걸어서 줄어들거 같기도 해서 츄라이했는데 400ms ~ 500ms로 통과됨
 * 투 포인터 쓴 사람은 100ms 대로 통과된거 보니까 골드3 문제라 그냥 봐준듯
 */
public class Main {

    static class Snowman implements Comparable<Snowman> {
        int head;
        int body;
        int height;

        public Snowman(int head, int body, int height) {
            this.head = head;
            this.body = body;
            this.height = height;
        }

        // 두 눈사람의 머리와 몸통이 서로 다르면 true 반환
        public boolean diff(Snowman snowman){
            return this.head != snowman.head && this.body != snowman.head && this.head != snowman.body && this.body != snowman.body;
        }

        @Override
        public int compareTo(Snowman o) {
            return Integer.compare(this.height, o.height);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for(int i=0 ; i<N ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        // initialCapacity를 지정해주면 더 빠르지 않을까 했는데 유의미한 차이는 모르겠음(김영한 보니까 진짜 별차이 없는듯)
        // 크기가 정해져 있어서 list를 쓸 필요도 없는데 인덱스 계산하기 피곤해서 list로 함
        List<Snowman> list = new ArrayList<>(N * (N-1) / 2);
        for(int i=0 ; i<N-1 ; i++){
            for(int j=i+1 ; j<N ; j++){
                list.add(new Snowman(i, j, input[i] + input[j]));
            }
        }
        Collections.sort(list);    // 정렬하면 그리디하게(안쪽 for문) 찾는게 정답 가능

        int ans = Integer.MAX_VALUE;

        for(int i=0 ; i<list.size()-1 ; i++){
            Snowman s1 = list.get(i);

            for(int j=i+1 ; j<list.size() ; j++){
                Snowman s2 = list.get(j);

                if(s2.height - s1.height > ans){    // 두 눈사람의 키 차이가 ans 보다 크면 비교가 무의미해서 넣어줬는데 큰 차이는 없음
                    break;
                }
                else if(s1.diff(s2)){    // 두 눈사람을 구성하는 눈덩이가 완전히 다르면
//                    ans = Math.min(ans, Math.abs(s1.height - s2.height));
                    ans = Math.min(ans, s2.height - s1.height);    // s2의 높이가 s1보다 항상 크거나 같음
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
