#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1 + 100000;
vector<int> adj[MAX_N];
int dist[MAX_N];
int order[MAX_N];

void bfs(int start) {
    queue<int> q;
    q.push(start);

    memset(dist, -1, sizeof(dist));
    dist[start] = 0;

    int cnt = 1;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        order[cur] = cnt++;

        for (int nxt : adj[cur]) {
            if (dist[nxt] != -1) continue;

            q.push(nxt);
            dist[nxt] = dist[cur] + 1;
        }
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
        sort(adj[i].begin(), adj[i].end());
    }

    bfs(r);

    long long ans = 0;
    for (int i = 1; i <= n; i++) {
        ans += 1LL * dist[i] * order[i];
    }

    cout << ans;
}
