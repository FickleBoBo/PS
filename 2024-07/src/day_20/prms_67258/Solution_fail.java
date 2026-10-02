package day_20.PGMS_LV3_보석_쇼핑;

import java.util.*;

class Solution_Fail {
    public int[] solution(String[] gems) {
        Set<String> total = new HashSet<>();
        for(String gem : gems) total.add(gem);

        int N = total.size();
        int[] ans = new int[]{1, gems.length};

        for(int i=0 ; i<gems.length ; i++){
            Set<String> set = new HashSet<>();

            for(int j=i ; j<gems.length ; j++){
                set.add(gems[j]);

                if(set.size() == N){
                    if(j-i < ans[1] - ans[0]){
                        ans[0] = i + 1;
                        ans[1] = j + 1;
                    }
                    else if((j-i == ans[1] - ans[0]) && i < ans[0]){
                        ans[0] = i + 1;
                        ans[1] = j + 1;
                    }
                }
            }
        }

        return ans;
    }
}

//테스트 1 〉	통과 (0.12ms, 74.1MB)
//테스트 2 〉	통과 (0.58ms, 77MB)
//테스트 3 〉	통과 (4.19ms, 73.3MB)
//테스트 4 〉	통과 (11.41ms, 83.6MB)
//테스트 5 〉	통과 (7.95ms, 81.4MB)
//테스트 6 〉	통과 (0.09ms, 76.3MB)
//테스트 7 〉	통과 (0.10ms, 74.8MB)
//테스트 8 〉	통과 (18.70ms, 73.1MB)
//테스트 9 〉	통과 (23.98ms, 77.8MB)
//테스트 10 〉통과 (29.35ms, 100MB)
//테스트 11 〉통과 (53.68ms, 102MB)
//테스트 12 〉통과 (41.95ms, 93.1MB)
//테스트 13 〉통과 (116.71ms, 87.1MB)
//테스트 14 〉통과 (160.72ms, 116MB)
//테스트 15 〉통과 (214.73ms, 85.1MB)

//테스트 1 〉	실패 (시간 초과)
//테스트 2 〉	실패 (시간 초과)
//테스트 3 〉	실패 (시간 초과)
//테스트 4 〉	실패 (시간 초과)
//테스트 5 〉	실패 (시간 초과)
//테스트 6 〉	실패 (시간 초과)
//테스트 7 〉	실패 (시간 초과)
//테스트 8 〉	실패 (시간 초과)
//테스트 9 〉	실패 (시간 초과)
//테스트 10 〉실패 (시간 초과)
//테스트 11 〉실패 (시간 초과)
//테스트 12 〉실패 (시간 초과)
//테스트 13 〉실패 (시간 초과)
//테스트 14 〉실패 (시간 초과)
//테스트 15 〉실패 (시간 초과)
