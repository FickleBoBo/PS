#include <bits/stdc++.h>
using namespace std;

string solution(string my_string, vector<vector<int>> queries) {
    for (auto& q : queries) {
        reverse(my_string.begin() + q[0], my_string.begin() + q[1] + 1);
    }

    return my_string;
}
