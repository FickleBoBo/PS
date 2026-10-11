#include <bits/stdc++.h>
using namespace std;

int days[1 + 12] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string week[7] = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

string solution(int a, int b) {
    int d = 0;
    for (int i = 1; i < a; i++) d += days[i];
    d += b;

    return week[d % 7];
}
