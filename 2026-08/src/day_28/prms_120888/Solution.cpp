#include <bits/stdc++.h>
using namespace std;

string solution(string my_string) {
    string s;
    set<char> st;

    for (char c : my_string) {
        if (st.count(c)) continue;
        s += c;
        st.insert(c);
    }

    return s;
}
