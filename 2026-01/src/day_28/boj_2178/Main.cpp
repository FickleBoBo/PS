#include <bits/stdc++.h>
using namespace std;

const int MAX = 100 + 1;
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
char grid[MAX][MAX];
bool vis[MAX][MAX];

int bfs() {
    queue<pair<int, int>> q;
    q.push({0, 0});

    vis[0][0] = true;

    int dist = 1;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [r, c] = q.front();
            q.pop();

            if (r == n - 1 && c == m - 1) return dist;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] == '0' || vis[nr][nc]) continue;

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

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    cout << bfs();
}
