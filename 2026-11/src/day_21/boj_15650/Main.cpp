#include <bits/stdc++.h>
using namespace std;

int n, m;
int sel[8];

void dfs(int start, int depth) {
    if (depth == m) {
        for (int i = 0; i < m; i++) {
            cout << sel[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = start; i <= n; i++) {
        sel[depth] = i;
        dfs(i + 1, depth + 1);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    dfs(1, 0);
}
