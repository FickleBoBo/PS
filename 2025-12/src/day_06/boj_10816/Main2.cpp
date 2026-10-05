#include <bits/stdc++.h>
using namespace std;

const int MAX = 10'000'000;
int cnt[MAX + 1 + MAX];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;
        cnt[x + MAX]++;
    }

    int m;
    cin >> m;

    while (m--) {
        int x;
        cin >> x;
        cout << cnt[x + MAX] << ' ';
    }
}
