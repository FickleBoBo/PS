#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int drh[8] = {-1, -2, -2, -1, 1, 2, 2, 1};
int dch[8] = {-2, -1, 1, 2, 2, 1, -1, -2};
int k, h, w;
int grid[200][200];
bool vis[200][200][1 + 30];

int bfs() {
    queue<tuple<int, int, int>> q;
    q.push({0, 0, 0});

    vis[0][0][0] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [r, c, t] = q.front();
            q.pop();

            if (r == h - 1 && c == w - 1) return dist;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (grid[nr][nc] == 1 || vis[nr][nc][t]) continue;

                q.push({nr, nc, t});
                vis[nr][nc][t] = true;
            }

            if (t == k) continue;

            for (int d = 0; d < 8; d++) {
                int nr = r + drh[d];
                int nc = c + dch[d];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (grid[nr][nc] == 1 || vis[nr][nc][t + 1]) continue;

                q.push({nr, nc, t + 1});
                vis[nr][nc][t + 1] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> k >> w >> h;

    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            cin >> grid[i][j];
        }
    }

    cout << bfs();
}
