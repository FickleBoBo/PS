#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    unordered_map<int, int> mp;

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;
        mp[x]++;
    }

    int m;
    cin >> m;

    while (m--) {
        int x;
        cin >> x;
        cout << mp[x] << ' ';
    }
}
