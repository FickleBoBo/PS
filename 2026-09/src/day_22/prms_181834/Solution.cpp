#include <bits/stdc++.h>
using namespace std;

string solution(string myString) {
    for (char& c : myString) c = max(c, 'l');
    return myString;
}
