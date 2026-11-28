#include <bits/stdc++.h>
using namespace std;

int k;
int arr[12];
int sel[6];

void dfs(int start, int depth) {
    if (depth == 6) {
        for (int x : sel) cout << x << ' ';
        cout << '\n';
        return;
    }

    for (int i = start; i < k; i++) {
        sel[depth] = arr[i];
        dfs(i + 1, depth + 1);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (true) {
        cin >> k;
        if (k == 0) break;

        for (int i = 0; i < k; i++) cin >> arr[i];

        dfs(0, 0);
        cout << '\n';
    }
}
