#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 100 + 1;
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n;
char grid[MAX_N][MAX_N];
bool vis[MAX_N][MAX_N];

bool same_color(char c1, char c2, bool is_blind) {
    if (!is_blind) return c1 == c2;
    if (c1 == 'B' || c2 == 'B') return c1 == c2;
    return true;
}

void bfs(int sr, int sc, bool is_blind) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    vis[sr][sc] = true;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (!same_color(grid[sr][sc], grid[nr][nc], is_blind) || vis[nr][nc]) continue;

            q.push({nr, nc});
            vis[nr][nc] = true;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    bool is_blind = false;
    for (int tc = 1; tc <= 2; tc++) {
        memset(vis, 0, sizeof(vis));
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) continue;

                bfs(i, j, is_blind);
                cnt++;
            }
        }
        cout << cnt << ' ';
        is_blind = !is_blind;
    }
}
