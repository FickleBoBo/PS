#include <bits/stdc++.h>
using namespace std;

bool vis[2187][2187];

void dfs(int sr, int sc, int n) {
    if (n == 1) {
        vis[sr][sc] = true;
        return;
    }

    dfs(sr, sc, n / 3);
    dfs(sr, sc + n / 3, n / 3);
    dfs(sr, sc + n / 3 * 2, n / 3);
    dfs(sr + n / 3, sc, n / 3);
    dfs(sr + n / 3, sc + n / 3 * 2, n / 3);
    dfs(sr + n / 3 * 2, sc, n / 3);
    dfs(sr + n / 3 * 2, sc + n / 3, n / 3);
    dfs(sr + n / 3 * 2, sc + n / 3 * 2, n / 3);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    dfs(0, 0, n);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (vis[i][j]) {
                cout << '*';
            } else {
                cout << ' ';
            }
        }
        cout << '\n';
    }
}
