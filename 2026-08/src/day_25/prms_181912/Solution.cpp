#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<string> intStrs, int k, int s, int l) {
    vector<int> v;
    for (auto& str : intStrs) {
        int x = stoi(str.substr(s, l));
        if (x > k) v.push_back(x);
    }

    return v;
}
