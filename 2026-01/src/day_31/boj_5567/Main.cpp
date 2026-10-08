#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1 + 500;
int n;
vector<int> adj[MAX_N];
bool vis[MAX_N];

int bfs() {
    queue<int> q;
    q.push(1);

    vis[1] = true;

    int dist = 0;
    int cnt = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int cur = q.front();
            q.pop();

            for (int nxt : adj[cur]) {
                if (vis[nxt]) continue;

                q.push(nxt);
                vis[nxt] = true;
                cnt++;
            }
        }

        dist++;
        if (dist == 2) break;
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int m;
    cin >> n >> m;

    while (m--) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    cout << bfs();
}
