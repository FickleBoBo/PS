#include <bits/stdc++.h>
using namespace std;

int cnt[26];

string solution(string s) {
    for (char c : s) cnt[c - 'a']++;

    string ans;
    for (int i = 0; i < 26; i++) {
        if (cnt[i] == 1) ans += i + 'a';
    }

    return ans;
}
