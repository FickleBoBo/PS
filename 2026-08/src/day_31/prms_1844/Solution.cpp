#include <bits/stdc++.h>
using namespace std;

const int MAXN = 100;
int dist[MAXN][MAXN];
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

int solution(vector<vector<int>> maps) {
    int n = maps.size(), m = maps[0].size();

    queue<pair<int, int>> q;
    q.push({0, 0});
    dist[0][0] = 1;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        if (r == n - 1 && c == m - 1) return dist[r][c];

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (maps[nr][nc] == 0 || dist[nr][nc] != 0) continue;

            q.push({nr, nc});
            dist[nr][nc] = dist[r][c] + 1;
        }
    }

    return -1;
}
