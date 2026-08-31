#include <bits/stdc++.h>
using namespace std;

vector<string> solution(vector<string> names) {
    vector<string> v;
    for (int i = 0; i < names.size(); i += 5) {
        v.push_back(names[i]);
    }

    return v;
}
