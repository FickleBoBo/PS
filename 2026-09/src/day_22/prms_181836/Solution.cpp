#include <bits/stdc++.h>
using namespace std;

vector<string> solution(vector<string> picture, int k) {
    vector<string> v;
    for (string& row : picture) {
        string s;
        for (char c : row) {
            s += string(k, c);
        }
        for (int j = 0; j < k; j++) {
            v.push_back(s);
        }
    }

    return v;
}
