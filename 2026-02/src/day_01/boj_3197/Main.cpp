#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
char grid[1500][1500];
bool vis[1500][1500];
int mark[1500][1500];
vector<pair<int, int>> pos;
queue<pair<int, int>> ice;

queue<pair<int, int>> bfs(int sr, int sc) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    vis[sr][sc] = true;

    queue<pair<int, int>> q2;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (vis[nr][nc]) continue;
            if (grid[nr][nc] == 'X') {
                q2.push({nr, nc});
                vis[nr][nc] = true;
                continue;
            }

            q.push({nr, nc});
            vis[nr][nc] = true;
        }
    }

    return q2;
}

void bfs() {
    int dist = 1;

    while (!ice.empty()) {
        int sz = ice.size();

        while (sz--) {
            auto [r, c] = ice.front();
            ice.pop();
            mark[r][c] = dist;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] != 'X' || vis[nr][nc]) continue;

                ice.push({nr, nc});
                vis[nr][nc] = true;
            }
        }

        dist++;
    }
}

bool bfs(int mx) {
    auto [sr, sc] = pos[0];
    auto [er, ec] = pos[1];

    queue<pair<int, int>> q;
    q.push({sr, sc});

    memset(vis, 0, sizeof(vis));
    vis[sr][sc] = true;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        if (r == er && c == ec) return true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (mark[nr][nc] > mx || vis[nr][nc]) continue;

            q.push({nr, nc});
            vis[nr][nc] = true;
        }
    }

    return false;
}

int lower_bound_param(int mx) {
    int lo = 0, hi = mx;

    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (!bfs(mid)) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }

    return hi;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> grid[i][j];
            if (grid[i][j] == 'L') pos.push_back({i, j});
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] != 'X' && !vis[i][j]) {
                queue<pair<int, int>> res = bfs(i, j);
                while (!res.empty()) {
                    ice.push(res.front());
                    res.pop();
                }
            }
        }
    }
    bfs();

    int mx = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            mx = max(mx, mark[i][j]);
        }
    }

    cout << lower_bound_param(mx);
}
