#include <bits/stdc++.h>
using namespace std;

int k;
int arr[12];
int sel[6];

void dfs(int idx, int sidx) {
    if (sidx == 6) {
        for (int x : sel) {
            cout << x << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = idx; i < k; i++) {
        sel[sidx] = arr[i];
        dfs(i + 1, sidx + 1);
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
