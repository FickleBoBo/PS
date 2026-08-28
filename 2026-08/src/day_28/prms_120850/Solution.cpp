#include <bits/stdc++.h>
using namespace std;

vector<int> solution(string my_string) {
    vector<int> v;
    for (char c : my_string) {
        if (isdigit(c)) v.push_back(c - '0');
    }
    sort(v.begin(), v.end());

    return v;
}
