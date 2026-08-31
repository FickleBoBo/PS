#include <bits/stdc++.h>
using namespace std;

const int MAXN = 200;
bool vis[MAXN];

void bfs(int start, int n, vector<vector<int>>& computers) {
    queue<int> q;
    q.push(start);

    vis[start] = true;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int nxt = 0; nxt < n; nxt++) {
            if (computers[cur][nxt] == 0 || vis[nxt]) continue;
            q.push(nxt);
            vis[nxt] = true;
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int cnt = 0;

    for (int i = 0; i < n; i++) {
        if (vis[i]) continue;
        bfs(i, n, computers);
        cnt++;
    }

    return cnt;
}
