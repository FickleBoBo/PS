#include <bits/stdc++.h>
using namespace std;

const int INF = 1'000'001;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> ans(queries.size(), INF);

    for (int i = 0; i < queries.size(); i++) {
        int s = queries[i][0];
        int e = queries[i][1];
        int k = queries[i][2];

        for (int j = s; j <= e; j++) {
            if (k < arr[j] && arr[j] < ans[i]) ans[i] = arr[j];
        }

        if (ans[i] == INF) ans[i] = -1;
    }

    return ans;
}
