#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1 + 100;
int n;
bool adj[MAX_N][MAX_N];
bool vis[MAX_N];

int bfs(int x, int y) {
    queue<int> q;
    q.push(x);

    vis[x] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int cur = q.front();
            q.pop();

            if (cur == y) return dist;

            for (int nxt = 1; nxt <= n; nxt++) {
                if (!adj[cur][nxt] || vis[nxt]) continue;

                q.push(nxt);
                vis[nxt] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int x, y, m;
    cin >> n >> x >> y >> m;

    while (m--) {
        int u, v;
        cin >> u >> v;
        adj[u][v] = adj[v][u] = true;
    }

    cout << bfs(x, y);
}
