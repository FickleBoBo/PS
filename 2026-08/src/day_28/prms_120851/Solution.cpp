#include <bits/stdc++.h>
using namespace std;

int solution(string my_string) {
    int sum = 0;
    for (char c : my_string) {
        if (isdigit(c)) sum += c - '0';
    }

    return sum;
}
