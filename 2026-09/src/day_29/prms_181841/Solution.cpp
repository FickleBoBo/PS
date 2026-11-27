#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> str_list, string ex) {
    string ans;
    for (string& s : str_list) {
        if (s.find(ex) == -1) ans += s;
    }

    return ans;
}
