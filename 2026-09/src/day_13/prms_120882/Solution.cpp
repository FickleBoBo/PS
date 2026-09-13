#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<vector<int>> score) {
    int n = score.size();
    vector<int> ans(n);

    for (int i = 0; i < n; i++) {
        int order = 1;
        for (int j = 0; j < n; j++) {
            if (score[i][0] + score[i][1] < score[j][0] + score[j][1]) order++;
        }
        ans[i] = order;
    }

    return ans;
}
