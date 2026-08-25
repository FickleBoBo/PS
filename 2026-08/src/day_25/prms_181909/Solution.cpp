#include <bits/stdc++.h>
using namespace std;

vector<string> solution(string my_string) {
    vector<string> v;
    for (int i = 0; i < my_string.size(); i++) {
        v.push_back(my_string.substr(i));
    }
    sort(v.begin(), v.end());

    return v;
}
