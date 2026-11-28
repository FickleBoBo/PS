#include <bits/stdc++.h>
using namespace std;

int arr[6] = {1, 1, 2, 2, 2, 8};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int x : arr) {
        int cnt;
        cin >> cnt;
        cout << x - cnt << ' ';
    }
}
