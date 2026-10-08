#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000 + 1;
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
char grid[MAX][MAX];
bool vis[MAX][MAX];
int chk[MAX][MAX];

void bfs(int sr, int sc) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    vis[sr][sc] = true;

    int cnt = 1;

    queue<pair<int, int>> q2;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (vis[nr][nc]) continue;
            if (grid[nr][nc] == '1') {
                q2.push({nr, nc});
                vis[nr][nc] = true;
                continue;
            }

            q.push({nr, nc});
            vis[nr][nc] = true;
            cnt++;
        }
    }

    while (!q2.empty()) {
        auto [r, c] = q2.front();
        q2.pop();

        chk[r][c] += cnt;
        vis[r][c] = false;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == '1') chk[i][j] = 1;
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == '1' || vis[i][j]) continue;

            bfs(i, j);
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << chk[i][j] % 10;
        }
        cout << '\n';
    }
}
