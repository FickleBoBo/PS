#include <bits/stdc++.h>
using namespace std;

int solution(string my_string) {
    for (char& c : my_string) {
        if (!isdigit(c)) c = ' ';
    }

    stringstream ss(my_string);
    int sum = 0;
    int x;
    while (ss >> x) sum += x;

    return sum;
}
