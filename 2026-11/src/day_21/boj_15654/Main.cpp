#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[8];
int sel[8];
bool vis[8];

void dfs(int depth) {
    if (depth == m) {
        for (int i = 0; i < m; i++) {
            cout << sel[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = 0; i < n; i++) {
        if (vis[i]) continue;

        sel[depth] = arr[i];
        vis[i] = true;
        dfs(depth + 1);
        vis[i] = false;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> arr[i];
    sort(arr, arr + n);

    dfs(0);
}
