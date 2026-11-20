#include <bits/stdc++.h>
using namespace std;

vector<long long> v;

void dfs(long long cur) {
    v.push_back(cur);
    for (int i = 0; i < cur % 10; i++) {
        dfs(cur * 10 + i);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i <= 9; i++) {
        dfs(i);
    }

    if (n >= v.size()) {
        cout << -1;
        return 0;
    }

    sort(v.begin(), v.end());
    cout << v[n];
}
