#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<string> operations) {
    multiset<int> ms;

    for (string& op : operations) {
        int x = stoi(op.substr(2));

        if (op[0] == 'I') {
            ms.insert(x);
        } else {
            if (ms.empty()) continue;
            ms.erase(x == 1 ? prev(ms.end()) : ms.begin());
        }
    }

    if (ms.empty()) return {0, 0};
    return {*ms.rbegin(), *ms.begin()};
}
