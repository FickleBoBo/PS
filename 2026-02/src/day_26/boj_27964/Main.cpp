#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    unordered_set<string> st;

    int n;
    cin >> n;

    while (n--) {
        string s;
        cin >> s;
        if (s.ends_with("Cheese")) st.insert(s);
    }

    if (st.size() >= 4) {
        cout << "yummy";
    } else {
        cout << "sad";
    }
}
