#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<string> intStrs, int k, int s, int l) {
    vector<int> v;
    for (string& intStr : intStrs) {
        int x = stoi(intStr.substr(s, l));
        if (x > k) v.push_back(x);
    }

    return v;
}
