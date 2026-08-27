#include <bits/stdc++.h>
using namespace std;

vector<int> solution(string my_string) {
    vector<int> cnt(52);
    for (char c : my_string) {
        if (isupper(c)) {
            cnt[c - 'A']++;
        } else {
            cnt[c - 'a' + 26]++;
        }
    }

    return cnt;
}
