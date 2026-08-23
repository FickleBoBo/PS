#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for (auto& q : queries) {
        int s = q[0];
        int e = q[1];
        int k = q[2];

        for (int i = s; i <= e; i++) {
            if (i % k == 0) arr[i]++;
        }
    }

    return arr;
}
