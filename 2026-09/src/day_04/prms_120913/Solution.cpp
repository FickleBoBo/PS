#include <bits/stdc++.h>
using namespace std;

vector<string> solution(string my_str, int n) {
    vector<string> v;
    for (int i = 0; i < my_str.size(); i += n) {
        v.push_back(my_str.substr(i, n));
    }

    return v;
}
