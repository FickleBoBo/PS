#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s, p;
    cin >> s >> p;
    cout << (strstr(s.c_str(), p.c_str()) != nullptr);
}
