#include <bits/stdc++.h>
using namespace std;

string solution(string my_string, vector<int> index_list) {
    string s;
    for (int i : index_list) s += my_string[i];
    return s;
}
