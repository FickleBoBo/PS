package day_17.BOJ_G4_1062;

import java.io.*;
import java.util.*;

/*
* 입력으로 들어오는 단어에서 a n t i c 를 제외하고 조합을 잘 돌리면 해결할 수 있어보였음
* (N과 K의 범위가 힌트?)
*
* alphaMap 에는 입력으로 들어온 모든 알파벳에서 저거 5개 빼고 중복 빼서 키로 넣고
* words 에는 각 단어에 대해서만 저거 수행
* alphaMap 에 있는 키들에 대해 조합을 돌리고, 돌려서 나온 조합에 대해 words의 모든 알파벳을 포함하면 한 단어 읽을 수 있는거라고 생각함
* 답은 맞게 나왔는데 시간이 716ms 라서 잘 못 푼 듯(100ms 초반이 정상 코드로 보임)
* 꽤 어렵네
*/

public class Main {

    static Map<Character, Boolean> alphaMap;    // 입력으로 나온 모든 알파벳을 키로 저장
    static Map<Character, Boolean>[] words;    // 각 단어에 대한 알파벳들을 키로 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        alphaMap = new HashMap<>();
        words = new HashMap[N];
        for(int i=0 ; i<N ; i++){
            words[i] = new HashMap<>();
        }

        for(int i=0 ; i<N ; i++){
            String input = br.readLine();

            for(int j=0 ; j<input.length() ; j++){
                alphaMap.put(input.charAt(j), true);
                words[i].put(input.charAt(j), true);
            }
        }

        // 조합 돌리는데 필요없는 a n t i c 제거
        alphaMap.remove('a');
        alphaMap.remove('n');
        alphaMap.remove('t');
        alphaMap.remove('i');
        alphaMap.remove('c');
        for(int i=0 ; i<N ; i++){
            words[i].remove('a');
            words[i].remove('n');
            words[i].remove('t');
            words[i].remove('i');
            words[i].remove('c');
        }

        // combination 준비
        // arr 에는 입력으로 주어진 모든 알파벳(a n t i c 제외)이 들어가야 함
        arr = new char[alphaMap.size()];
        int idx = 0;
        for(Character c : alphaMap.keySet()){
            arr[idx++] = c;
        }

        // a n t i c 는 뽑았다고 가정하고 조합을 돌리므로 5개 빼줌
        R = K - 5;
        sel = new ArrayList<>();
        for(int i=0 ; i<R ; i++){
            sel.add(null);    // combination에서 바로 set하려고 null로 일단 채움
        }

        // nCr 은 n이 r보다 크거나 같은게 기본 조건이라 r이 n 보다 크면 N 출력하고 main 종료
        // 40% 후반에 걸리는 테케있음
        if(K-5 > alphaMap.size()){
            System.out.println(N);
            return;
        }
        else if(K >= 5){
            combination(0, 0);
        }
        System.out.println(ans);
    }

    static char[] arr;

    static int R;
    static List<Character> sel;    // contains 쓰려고 리스트로 선언

    static int ans = 0;

    private static void combination(int idx, int sidx){
        if(sidx == R){
            int cnt = 0;

            // sel에는 입력으로 들어온 알파벳에서 R개를 뽑은게 들어있음
            // 각 단어에 대해 각 단어의 모든 알파벳이 sel에 포함되어 있으면 읽을 수 있는 단어
            out:
            for (Map<Character, Boolean> word : words) {
                for (Character c : word.keySet()) {
                    if (!sel.contains(c)) {
                        continue out;
                    }
                }
                cnt++;
            }
            ans = Math.max(ans, cnt);
            return;
        }

        for(int i=idx ; i<alphaMap.size() ; i++){
            sel.set(sidx, arr[i]);
            combination(i+1, sidx+1);
        }
    }

}
