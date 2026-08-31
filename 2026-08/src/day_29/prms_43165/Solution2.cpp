#include <bits/stdc++.h>
using namespace std;

int dfs(int cur, int depth, vector<int>& numbers, int target) {
    if (depth == numbers.size()) return cur == target;

    return dfs(cur + numbers[depth], depth + 1, numbers, target) +
           dfs(cur - numbers[depth], depth + 1, numbers, target);
}

int solution(vector<int> numbers, int target) {
    return dfs(0, 0, numbers, target);
}
