#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1 + 20000;
vector<int> adj[MAX_N];
bool vis[MAX_N];

int solution(int n, vector<vector<int>> edge) {
    for (auto& e : edge) {
        adj[e[0]].push_back(e[1]);
        adj[e[1]].push_back(e[0]);
    }

    queue<int> q;
    q.push(1);

    vis[1] = true;

    int ans = 0;
    while (!q.empty()) {
        ans = q.size();
        int sz = q.size();
        while (sz--) {
            int cur = q.front();
            q.pop();

            for (int nxt : adj[cur]) {
                if (vis[nxt]) continue;
                q.push(nxt);
                vis[nxt] = true;
            }
        }
    }

    return ans;
}
