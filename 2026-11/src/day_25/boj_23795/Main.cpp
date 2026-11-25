#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int sum = 0;
    while (true) {
        int x;
        cin >> x;

        if (x == -1) break;
        sum += x;
    }

    cout << sum;
}
