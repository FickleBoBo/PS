#include <bits/stdc++.h>
using namespace std;

string solution(string myString, string pat) {
    return myString.substr(0, myString.rfind(pat) + pat.size());
}
