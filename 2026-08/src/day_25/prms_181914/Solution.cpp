#include <bits/stdc++.h>
using namespace std;

int solution(string number) {
    int sum = 0;
    for (char c : number) sum += c - '0';
    return sum % 9;
}
