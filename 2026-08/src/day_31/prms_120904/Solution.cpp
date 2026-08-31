#include <bits/stdc++.h>
using namespace std;

int solution(int num, int k) {
    int idx = to_string(num).find('0' + k);
    return idx != -1 ? idx + 1 : -1;
}
