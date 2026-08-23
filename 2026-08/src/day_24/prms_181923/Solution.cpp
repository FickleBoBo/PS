#include <bits/stdc++.h>
using namespace std;

int INF = 1'000'001;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> v(queries.size(), INF);

    for (int i = 0; i < queries.size(); i++) {
        int s = queries[i][0];
        int e = queries[i][1];
        int k = queries[i][2];

        for (int j = s; j <= e; j++) {
            if (arr[j] > k && arr[j] < v[i]) v[i] = arr[j];
        }

        if (v[i] == INF) v[i] = -1;
    }

    return v;
}
