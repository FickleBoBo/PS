#include <bits/stdc++.h>
using namespace std;

string solution(string polynomial) {
    stringstream ss(polynomial);
    string token;
    vector<int> cnt(2);

    while (ss >> token) {
        if (token == "+") continue;

        if (token.ends_with("x")) {
            if (token.size() == 1) {
                cnt[0]++;
            } else {
                cnt[0] += stoi(token.substr(0, token.size() - 1));
            }
        } else {
            cnt[1] += stoi(token);
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
