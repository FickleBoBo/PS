#include <bits/stdc++.h>
using namespace std;

string solution(vector<int> numLog) {
    string s;
    for (int i = 1; i < numLog.size(); i++) {
        int prv = numLog[i - 1];
        int cur = numLog[i];

        if (prv + 1 == cur) {
            s += 'w';
        } else if (prv - 1 == cur) {
            s += 's';
        } else if (prv + 10 == cur) {
            s += 'd';
        } else {
            s += 'a';
        }
    }

    return s;
}
