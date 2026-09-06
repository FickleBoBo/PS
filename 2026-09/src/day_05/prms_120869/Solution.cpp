#include <bits/stdc++.h>
using namespace std;

int solution(vector<string> spell, vector<string> dic) {
    string word;
    for (string& s : spell) word += s;
    sort(word.begin(), word.end());

    for (string& s : dic) {
        sort(s.begin(), s.end());
        if (word == s) return 1;
    }

    return 2;
}
