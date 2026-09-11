#include <bits/stdc++.h>
using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> v;
    for (string& s : strArr) {
        if (s.find("ad") != -1) continue;
        v.push_back(s);
    }

    return v;
}
