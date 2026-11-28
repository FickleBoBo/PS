#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[7];
int sel[7];

void dfs(int depth) {
    if (depth == m) {
        for (int i = 0; i < m; i++) cout << sel[i] << ' ';
        cout << '\n';
        return;
    }

    int prv = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] == prv) continue;

        prv = sel[depth] = arr[i];
        dfs(depth + 1);
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
