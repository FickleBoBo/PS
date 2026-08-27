#include <bits/stdc++.h>
using namespace std;

int solution(string my_string, string is_prefix) {
    return my_string.compare(0, is_prefix.size(), is_prefix) == 0;
}
