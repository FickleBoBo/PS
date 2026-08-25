#include <bits/stdc++.h>
using namespace std;

int solution(string my_string, string is_suffix) {
    if (is_suffix.size() > my_string.size()) return 0;
    return my_string.substr(my_string.size() - is_suffix.size()) == is_suffix;
}
