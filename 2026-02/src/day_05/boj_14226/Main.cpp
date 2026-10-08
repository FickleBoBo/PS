#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000;
bool vis[1 + MAX][1 + MAX];

int bfs(int s) {
    queue<pair<int, int>> q;
    q.push({1, 0});

    vis[1][0] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [a, b] = q.front();
            q.pop();

            if (a == s) return dist;

            if (!vis[a][a]) {
                q.push({a, a});
                vis[a][a] = true;
            }

            if (a + b <= MAX && !vis[a + b][b]) {
                q.push({a + b, b});
                vis[a + b][b] = true;
            }

            if (a > 0 && !vis[a - 1][b]) {
                q.push({a - 1, b});
                vis[a - 1][b] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int s;
    cin >> s;
    cout << bfs(s);
}
