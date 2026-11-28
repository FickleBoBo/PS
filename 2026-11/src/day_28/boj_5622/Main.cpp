#include <bits/stdc++.h>
using namespace std;

int arr[26] = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    int sum = 0;
    for (char c : s) {
        sum += arr[c - 'A'];
    }

    cout << sum;
}
