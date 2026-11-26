#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    cin.ignore();

    while (n--) {
        string line;
        getline(cin, line);

        line[0] = toupper(line[0]);
        cout << line << '\n';
    }
}
