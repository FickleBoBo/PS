#include <bits/stdc++.h>
using namespace std;

const int MAX = 30 + 1;
int dz[6] = {0, 0, 0, 0, -1, 1};
int dr[6] = {-1, 0, 1, 0, 0, 0};
int dc[6] = {0, 1, 0, -1, 0, 0};
int h, n, m;
char grid[MAX][MAX][MAX];
bool vis[MAX][MAX][MAX];

int bfs(auto s, auto e) {
    auto [sz, sr, sc] = s;
    auto [ez, er, ec] = e;

    queue<tuple<int, int, int>> q;
    q.push(s);

    vis[sz][sr][sc] = true;

    int dist = 0;

    while (!q.empty()) {
        int qsz = q.size();

        while (qsz--) {
            auto [z, r, c] = q.front();
            q.pop();

            if (z == ez && r == er && c == ec) return dist;

            for (int d = 0; d < 6; d++) {
                int nz = z + dz[d];
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nz < 0 || nz >= h || nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nz][nr][nc] == '#' || vis[nz][nr][nc]) continue;

                q.push({nz, nr, nc});
                vis[nz][nr][nc] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (true) {
        cin >> h >> n >> m;
        if (h == 0 && n == 0 && m == 0) break;

        memset(vis, 0, sizeof(vis));
        tuple<int, int, int> s, e;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                cin >> grid[i][j];
                for (int k = 0; k < m; k++) {
                    if (grid[i][j][k] == 'S') {
                        s = {i, j, k};
                    } else if (grid[i][j][k] == 'E') {
                        e = {i, j, k};
                    }
                }
            }
        }

        int dist = bfs(s, e);
        if (dist == -1) {
            cout << "Trapped!\n";
        } else {
            cout << "Escaped in " << dist << " minute(s).\n";
        }
    }
}
