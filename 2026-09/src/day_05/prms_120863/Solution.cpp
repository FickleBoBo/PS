#include <bits/stdc++.h>
using namespace std;

string solution(string polynomial) {
    stringstream ss(polynomial);
    string s;
    vector<int> cnt(2);

    while (ss >> s) {
        if (s == "+") continue;

        if (s.ends_with("x")) {
            if (s.size() == 1) {
                cnt[0]++;
            } else {
                cnt[0] += stoi(s.substr(0, s.size() - 1));
            }
        } else {
            cnt[1] += stoi(s);
        }
    }

    if (cnt[0] == 0) {
        return to_string(cnt[1]);
    } else if (cnt[1] == 0) {
        return (cnt[0] == 1 ? "" : to_string(cnt[0])) + "x";
    } else {
        return (cnt[0] == 1 ? "" : to_string(cnt[0])) + "x + " + to_string(cnt[1]);
    }
}
