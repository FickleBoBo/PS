#include <bits/stdc++.h>
using namespace std;

bool vis[3072][3072 * 2];

void dfs(int sr, int sc, int n) {
    if (n == 3) {
        vis[sr][sc + 2] = true;
        vis[sr + 1][sc + 1] = true;
        vis[sr + 1][sc + 3] = true;
        vis[sr + 2][sc] = true;
        vis[sr + 2][sc + 1] = true;
        vis[sr + 2][sc + 2] = true;
        vis[sr + 2][sc + 3] = true;
        vis[sr + 2][sc + 4] = true;
        return;
    }

    dfs(sr, sc + n / 2, n / 2);
    dfs(sr + n / 2, sc, n / 2);
    dfs(sr + n / 2, sc + n, n / 2);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    dfs(0, 0, n);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n * 2; j++) {
            if (vis[i][j]) {
                cout << '*';
            } else {
                cout << ' ';
            }
        }
        cout << '\n';
    }
}
