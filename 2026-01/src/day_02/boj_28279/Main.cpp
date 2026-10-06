#include <bits/stdc++.h>
using namespace std;

const int MAX = 2'000'000;
int dq[MAX];
int s = MAX / 2, e = MAX / 2;

void push_front(int x) {
    dq[--s] = x;
}

void push_back(int x) {
    dq[e++] = x;
}

void pop_front() {
    s++;
}

void pop_back() {
    e--;
}

int size() {
    return e - s;
}

bool empty() {
    return s == e;
}

int front() {
    return dq[s];
}

int back() {
    return dq[e - 1];
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int q;
        cin >> q;

        if (q == 1) {
            int x;
            cin >> x;
            push_front(x);
        } else if (q == 2) {
            int x;
            cin >> x;
            push_back(x);
        } else if (q == 3) {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << front() << '\n';
                pop_front();
            }
        } else if (q == 4) {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << back() << '\n';
                pop_back();
            }
        } else if (q == 5) {
            cout << size() << '\n';
        } else if (q == 6) {
            cout << empty() << '\n';
        } else if (q == 7) {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << front() << '\n';
            }
        } else {
            if (empty()) {
                cout << -1 << '\n';
            } else {
                cout << back() << '\n';
            }
        }
    }
}
