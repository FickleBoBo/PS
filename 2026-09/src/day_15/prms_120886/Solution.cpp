#include <bits/stdc++.h>
using namespace std;

int solution(string before, string after) {
    sort(before.begin(), before.end());
    sort(after.begin(), after.end());
    return before == after;
}
