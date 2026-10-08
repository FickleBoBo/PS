#include <bits/stdc++.h>
using namespace std;

vector<int> p(1 + 1000, -1);

int find(int x) {
    if (p[x] < 0) return x;
    return p[x] = find(p[x]);
}

void unite(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) p[y] = x;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    while (m--) {
        int u, v;
        cin >> u >> v;
        unite(u, v);
    }

    int cnt = 0;
    for (int node = 1; node <= n; node++) {
        if (node == find(node)) cnt++;
    }

    cout << cnt;
}
