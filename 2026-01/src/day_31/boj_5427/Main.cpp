#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000 + 1;
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int h, w;
char grid[MAX][MAX];
bool vis[MAX][MAX];

int bfs(int sr, int sc, queue<pair<int, int>>& fire) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    vis[sr][sc] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = fire.size();

        while (sz--) {
            auto [r, c] = fire.front();
            fire.pop();

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (grid[nr][nc] == '#' || grid[nr][nc] == '*') continue;

                fire.push({nr, nc});
                grid[nr][nc] = '*';
            }
        }

        sz = q.size();
        while (sz--) {
            auto [r, c] = q.front();
            q.pop();

            if (r == 0 || r == h - 1 || c == 0 || c == w - 1) return dist + 1;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (grid[nr][nc] != '.' || vis[nr][nc]) continue;

                q.push({nr, nc});
                vis[nr][nc] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        cin >> w >> h;

        memset(vis, 0, sizeof(vis));

        int sr, sc;
        queue<pair<int, int>> q;

        for (int i = 0; i < h; i++) {
            cin >> grid[i];
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '@') {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == '*') {
                    q.push({i, j});
                }
            }
        }

        int res = bfs(sr, sc, q);
        if (res == -1) {
            cout << "IMPOSSIBLE\n";
        } else {
            cout << res << '\n';
        }
    }
}
