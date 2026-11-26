#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    cin.ignore();

    for (int i = 1; i <= n; i++) {
        string line;
        getline(cin, line);
        cout << i << ". " << line << '\n';
    }
}
