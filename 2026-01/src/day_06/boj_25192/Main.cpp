#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    set<string> st;
    int cnt = 0;

    while (n--) {
        string line;
        cin >> line;

        if (line == "ENTER") {
            cnt += st.size();
            st.clear();
        } else {
            st.insert(line);
        }
    }
    cnt += st.size();

    cout << cnt;
}
