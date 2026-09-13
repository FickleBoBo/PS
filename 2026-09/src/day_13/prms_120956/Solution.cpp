#include <bits/stdc++.h>
using namespace std;

int solution(vector<string> babbling) {
    int cnt = 0;
    for (string& s : babbling) {
        for (string p : {"aya", "ye", "woo", "ma"}) {
            int pos = s.find(p);
            if (pos != -1) s.replace(pos, p.size(), " ");
        }

        bool ok = true;
        for (char c : s) {
            if (!isspace(c)) ok = false;
        }
        if (ok) cnt++;
    }

    return cnt;
}
