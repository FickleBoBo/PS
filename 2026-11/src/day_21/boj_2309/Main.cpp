#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<int> v(9);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    int sum = 0;
    for (int x : v) sum += x;

    for (int i = 0; i < 8; i++) {
        for (int j = i + 1; j < 9; j++) {
            if (sum - v[i] - v[j] == 100) {
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j) {
                        cout << v[k] << '\n';
                    }
                }

                return 0;
            }
        }
    }
}
