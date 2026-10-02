package day_20.PGMS_LV3_보석_쇼핑;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {

        // 보석의 종류를 안알려줘서 HashSet으로 보석의 종류를 일단 구함
        Set<String> total = new HashSet<>();
        for(String gem : gems) total.add(gem);

        // 보석의 종류의 수 N과 모든 보석을 다 담았다고 가정한 ans 배열을 초기화
        int N = total.size();
        int[] ans = new int[]{1, gems.length};

        // gems 배열의 크기가 10만이라 2중 for문은 효율성 테스트에 걸려서 투 포인터로 찾기
        int st = 0;    // gems 배열에 대해 보석을 담은 시작 인덱스
        int ed = 0;    // gems 배열에 대해 보석을 담은 끝 인덱스 + 1

        // <보석의 종류, 보석의 개수>
        Map<String, Integer> map = new HashMap<>();

        while(true){
            // 1. 모든 종류를 담았을 경우
            if(map.size() == N){
                // 조건 맞춰서 ans 갱신
                if(ans[1] - ans[0] > ed - st){    // 구간의 길이가 짧은게 우선
                    ans[0] = st + 1;
                    ans[1] = ed;
                }
                else if((ans[1] - ans[0] == ed - st) && (ans[0] < st + 1)){    // 구간의 길이가 같으면 시작 인덱스가 작은게 우선
                    ans[0] = st + 1;
                    ans[1] = ed;
                }

                // ans 갱신하면 이제 투 포인터의 시작 인덱스를 이동하는데 map 갱신 조건을 잘 생각해야함
                // 보석이 하나만 있으면 키를 없애줘야 하고 보석이 여러개면 개수를 줄여줘야 함
                if(map.get(gems[st]) == 1){
                    map.remove(gems[st]);
                }
                else{
                    map.put(gems[st], map.get(gems[st]) - 1);
                }

                st++;
            }
            // 2. 모든 종류를 담지 못했을 경우
            // 더 담아야해서 ed 위치를 이동하고 map 갱신(순서로는 map 먼저 갱신하고 ed 이동)
            else{
                map.put(gems[ed], map.getOrDefault(gems[ed], 0) + 1);
                ed++;
            }

            // 3. 종료 조건
            // map.size() < N 이걸로 시작 인덱스도 최대한 줄여야 됨(정확성 테스트 6, 7번)
            if(ed == gems.length && map.size() < N) break;
        }

        return ans;
    }
}

//테스트 1 〉	통과 (0.10ms, 73.5MB)
//테스트 2 〉	통과 (0.18ms, 73.1MB)
//테스트 3 〉	통과 (0.52ms, 77.9MB)
//테스트 4 〉	통과 (0.58ms, 74MB)
//테스트 5 〉	통과 (0.68ms, 70.9MB)
//테스트 6 〉	통과 (0.09ms, 72.8MB)
//테스트 7 〉	통과 (0.07ms, 75.3MB)
//테스트 8 〉	통과 (0.60ms, 81.5MB)
//테스트 9 〉	통과 (0.83ms, 77.9MB)
//테스트 10 〉통과 (0.63ms, 78.2MB)
//테스트 11 〉통과 (0.83ms, 72.8MB)
//테스트 12 〉통과 (1.76ms, 80.2MB)
//테스트 13 〉통과 (1.53ms, 73.4MB)
//테스트 14 〉통과 (1.29ms, 76.5MB)
//테스트 15 〉통과 (2.15ms, 87.9MB)

//테스트 1 〉	통과 (8.99ms, 72MB)
//테스트 2 〉	통과 (10.84ms, 59.3MB)
//테스트 3 〉	통과 (15.06ms, 58.2MB)
//테스트 4 〉	통과 (12.48ms, 61.8MB)
//테스트 5 〉	통과 (23.13ms, 63.5MB)
//테스트 6 〉	통과 (29.08ms, 63.7MB)
//테스트 7 〉	통과 (26.23ms, 64.4MB)
//테스트 8 〉	통과 (34.74ms, 67.1MB)
//테스트 9 〉	통과 (39.78ms, 87.2MB)
//테스트 10 〉통과 (37.08ms, 75MB)
//테스트 11 〉통과 (44.44ms, 78.2MB)
//테스트 12 〉통과 (32.49ms, 95.9MB)
//테스트 13 〉통과 (38.36ms, 80.3MB)
//테스트 14 〉통과 (44.67ms, 80MB)
//테스트 15 〉통과 (51.56ms, 80.9MB)
