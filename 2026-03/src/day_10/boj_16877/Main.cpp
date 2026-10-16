#include <bits/stdc++.h>
using namespace std;

const int MAX = 3'000'000;
int fibo[32];  // 전처리로 미리 크기 계산
int g[1 + MAX];
bool seen[16];  // 전처리로 미리 크기 계산

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    fibo[0] = fibo[1] = 1;
    for (int i = 2; i < 32; i++) {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
    }

    for (int i = 1; i <= MAX; i++) {
        memset(seen, 0, sizeof(seen));
        for (int x : fibo) {
            if (i >= x) seen[g[i - x]] = true;
        }

        int mex = 0;
        while (seen[mex]) mex++;
        g[i] = mex;
    }

    int nimsum = 0;

    int n;
    cin >> n;

    while (n--) {
        int p;
        cin >> p;
        nimsum ^= g[p];
    }

    if (nimsum) {
        cout << "koosaga";
    } else {
        cout << "cubelover";
    }
}
