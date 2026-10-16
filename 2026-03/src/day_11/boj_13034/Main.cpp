#include <bits/stdc++.h>
using namespace std;

int g[1 + 1000];
bool seen[16];  // 전처리로 미리 크기 계산

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 2; i <= n; i++) {
        memset(seen, 0, sizeof(seen));
        for (int j = 0; j <= (i - 1) / 2; j++) {
            seen[g[j] ^ g[i - 2 - j]] = true;
        }

        int mex = 0;
        while (seen[mex]) mex++;
        g[i] = mex;
    }

    if (g[n]) {
        cout << 1;
    } else {
        cout << 2;
    }
}
