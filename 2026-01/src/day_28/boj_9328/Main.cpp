#include <bits/stdc++.h>
using namespace std;

const int MAX = 1 + 100 + 1;
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
char grid[MAX][MAX];
bool vis[MAX][MAX];
bool has_key[26];

int bfs(int n, int m) {
    queue<pair<int, int>> q;
    q.push({0, 0});

    vector<queue<pair<int, int>>> doors(26);

    vis[0][0] = true;

    int cnt = 0;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        if (grid[r][c] == '$') cnt++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (grid[nr][nc] == '*' || vis[nr][nc]) continue;

            if ('A' <= grid[nr][nc] && grid[nr][nc] <= 'Z') {
                if (!has_key[grid[nr][nc] - 'A']) {
                    doors[grid[nr][nc] - 'A'].push({nr, nc});
                    vis[nr][nc] = true;
                    continue;
                }
            }

            if ('a' <= grid[nr][nc] && grid[nr][nc] <= 'z') {
                has_key[grid[nr][nc] - 'a'] = true;
                while (!doors[grid[nr][nc] - 'a'].empty()) {
                    q.push(doors[grid[nr][nc] - 'a'].front());
                    doors[grid[nr][nc] - 'a'].pop();
                }
            }

            q.push({nr, nc});
            vis[nr][nc] = true;
        }
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int h, w;
        cin >> h >> w;

        int n = h + 2;
        int m = w + 2;

        memset(vis, 0, sizeof(vis));
        for (int i = 0; i < n; i++) {
            grid[i][0] = grid[i][m - 1] = '.';
        }
        for (int j = 0; j < m; j++) {
            grid[0][j] = grid[n - 1][j] = '.';
        }

        for (int i = 1; i <= h; i++) {
            string s;
            cin >> s;

            for (int j = 1; j <= w; j++) {
                grid[i][j] = s[j - 1];
            }
        }

        string s;
        cin >> s;

        memset(has_key, 0, sizeof(has_key));
        if (s != "0") {
            for (char c : s) {
                has_key[c - 'a'] = true;
            }
        }

        cout << bfs(n, m) << '\n';
    }
}
