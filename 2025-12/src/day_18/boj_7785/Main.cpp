#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    set<string, greater<>> st;

    int n;
    cin >> n;

    while (n--) {
        string name, type;
        cin >> name >> type;

        if (type == "enter") {
            st.insert(name);
        } else {
            st.erase(name);
        }
    }

    for (auto& name : st) {
        cout << name << '\n';
    }
}
