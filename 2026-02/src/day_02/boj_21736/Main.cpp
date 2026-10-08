#include <bits/stdc++.h>
using namespace std;

const int MAX = 600 + 1;
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
char grid[MAX][MAX];
bool vis[MAX][MAX];

int bfs(int sr, int sc) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    vis[sr][sc] = true;

    int cnt = 0;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        if (grid[r][c] == 'P') cnt++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (grid[nr][nc] == 'X' || vis[nr][nc]) continue;

            q.push({nr, nc});
            vis[nr][nc] = true;
        }
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    int sr, sc;
    for (int i = 0; i < n; i++) {
        cin >> grid[i];
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 'I') {
                sr = i;
                sc = j;
            }
        }
    }

    int cnt = bfs(sr, sc);
    if (cnt > 0) {
        cout << cnt;
    } else {
        cout << "TT";
    }
}
