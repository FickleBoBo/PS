#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<pair<int, string>> v(n);
    for (auto& [age, name] : v) cin >> age >> name;
    stable_sort(v.begin(), v.end(), [](auto& a, auto& b) {
        return a.first < b.first;
    });

    for (auto& [age, name] : v) {
        cout << age << ' ' << name << '\n';
    }
}
