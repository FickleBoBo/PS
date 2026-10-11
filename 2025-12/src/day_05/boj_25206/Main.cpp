#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    double total_sum = 0;
    double credit_sum = 0;
    for (int i = 0; i < 20; i++) {
        string s, grade;
        double credit;
        cin >> s >> credit >> grade;

        if (grade == "P") continue;

        if (grade == "A+") {
            total_sum += credit * 4.5;
        } else if (grade == "A0") {
            total_sum += credit * 4.0;
        } else if (grade == "B+") {
            total_sum += credit * 3.5;
        } else if (grade == "B0") {
            total_sum += credit * 3.0;
        } else if (grade == "C+") {
            total_sum += credit * 2.5;
        } else if (grade == "C0") {
            total_sum += credit * 2.0;
        } else if (grade == "D+") {
            total_sum += credit * 1.5;
        } else if (grade == "D0") {
            total_sum += credit;
        }
        credit_sum += credit;
    }

    cout << total_sum / credit_sum;
}
