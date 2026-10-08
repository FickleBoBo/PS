#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1 + 1000;
vector<int> adj[MAX_N];
bool vis[MAX_N];

void dfs(int cur) {
    vis[cur] = true;

    for (int nxt : adj[cur]) {
        if (vis[nxt]) continue;
        dfs(nxt);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    while (m--) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int cnt = 0;
    for (int node = 1; node <= n; node++) {
        if (vis[node]) continue;

        dfs(node);
        cnt++;
    }

    cout << cnt;
}
