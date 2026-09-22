#include <bits/stdc++.h>
using namespace std;

string solution(string n_str) {
    return n_str.substr(n_str.find_first_not_of('0'));
}
