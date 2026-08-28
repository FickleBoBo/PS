#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<string> strlist) {
    vector<int> v;
    for (string& s : strlist) {
        v.push_back(s.length());
    }

    return v;
}
