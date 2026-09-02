#include <bits/stdc++.h>
using namespace std;

string solution(string my_string) {
    for (char& c : my_string) c = tolower(c);
    sort(my_string.begin(), my_string.end());
    return my_string;
}
