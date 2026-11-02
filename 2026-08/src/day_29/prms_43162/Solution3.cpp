#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 200;
vector<int> p(MAX_N);

int find(int x) {
    if (x == p[x]) return x;
    return p[x] = find(p[x]);
}

bool unite(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) return false;
    p[x] = y;
    return true;
}

int solution(int n, vector<vector<int>> computers) {
    iota(p.begin(), p.end(), 0);

    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (computers[i][j]) unite(i, j);
        }
    }

    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (i == p[i]) cnt++;
    }

    return cnt;
}
