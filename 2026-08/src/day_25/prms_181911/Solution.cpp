#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> my_strings, vector<vector<int>> parts) {
    string s;
    for (int i = 0; i < my_strings.size(); i++) {
        s += my_strings[i].substr(parts[i][0], parts[i][1] - parts[i][0] + 1);
    }

    return s;
}
