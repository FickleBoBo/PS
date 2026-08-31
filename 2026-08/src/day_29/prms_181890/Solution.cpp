#include <bits/stdc++.h>
using namespace std;

vector<string> solution(vector<string> str_list) {
    int n = str_list.size();

    for (int i = 0; i < n; i++) {
        if (str_list[i] == "l") {
            return vector<string>(str_list.begin(), str_list.begin() + i);
        }
        if (str_list[i] == "r") {
            return vector<string>(str_list.begin() + i + 1, str_list.end());
        }
    }

    return {};
}
