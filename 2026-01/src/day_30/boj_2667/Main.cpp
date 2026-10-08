#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 25 + 1;
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n;
char grid[MAX_N][MAX_N];

int bfs(int sr, int sc) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    grid[sr][sc] = '0';

    int cnt = 1;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (grid[nr][nc] == '0') continue;

            q.push({nr, nc});
            grid[nr][nc] = '0';
            cnt++;
        }
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    int cnt = 0;
    vector<int> v;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
                cnt++;
                v.push_back(bfs(i, j));
            }
        }
    }
    sort(v.begin(), v.end());

    cout << cnt << '\n';
    for (int x : v) {
        cout << x << '\n';
    }
}
