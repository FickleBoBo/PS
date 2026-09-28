#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> str_list, string ex) {
    string res;
    for (string& s : str_list) {
        if (s.find(ex) == -1) res += s;
    }

    return res;
}
