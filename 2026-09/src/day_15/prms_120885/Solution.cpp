#include <bits/stdc++.h>
using namespace std;

string solution(string bin1, string bin2) {
    int sum = stoi(bin1, 0, 2) + stoi(bin2, 0, 2);
    if (sum == 0) return "0";

    string ans;
    while (sum > 0) {
        ans += '0' + sum % 2;
        sum /= 2;
    }
    reverse(ans.begin(), ans.end());

    return ans;
}
