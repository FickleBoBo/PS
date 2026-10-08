#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1 + 100000;
vector<int> adj[MAX_N];
bool vis[MAX_N];
int order[MAX_N];
int cnt = 1;

void dfs(int cur) {
    vis[cur] = true;
    order[cur] = cnt++;

    for (int nxt : adj[cur]) {
        if (vis[nxt]) continue;
        dfs(nxt);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m, r;
    cin >> n >> m >> r;

    while (m--) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 1; i <= n; i++) {
        sort(adj[i].rbegin(), adj[i].rend());
    }

    dfs(r);

    for (int i = 1; i <= n; i++) {
        cout << order[i] << '\n';
    }
}
