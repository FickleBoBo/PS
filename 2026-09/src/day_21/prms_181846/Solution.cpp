#include <bits/stdc++.h>
using namespace std;

string solution(string a, string b) {
    string s;
    int i = a.size() - 1, j = b.size() - 1, carry = 0;
    while (i >= 0 || j >= 0 || carry) {
        int sum = carry;
        if (i >= 0) sum += a[i--] - '0';
        if (j >= 0) sum += b[j--] - '0';
        s += sum % 10 + '0';
        carry = sum / 10;
    }
    reverse(s.begin(), s.end());

    return s;
}
