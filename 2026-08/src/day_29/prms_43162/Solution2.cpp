#include <bits/stdc++.h>
using namespace std;

const int MAXN = 200;
bool vis[MAXN];

void dfs(int cur, int n, vector<vector<int>>& computers) {
    vis[cur] = true;

    for (int nxt = 0; nxt < n; nxt++) {
        if (computers[cur][nxt] == 0 || vis[nxt]) continue;
        dfs(nxt, n, computers);
    }
}

int solution(int n, vector<vector<int>> computers) {
    int cnt = 0;

    for (int i = 0; i < n; i++) {
        if (vis[i]) continue;
        dfs(i, n, computers);
        cnt++;
    }

    return cnt;
}
