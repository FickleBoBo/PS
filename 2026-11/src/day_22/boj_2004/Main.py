import sys

input = sys.stdin.readline


def count_factor(x, div):
    cnt = 0
    while x > 0:
        x //= div
        cnt += x
    return cnt


n, m = map(int, input().split())
cnt2 = count_factor(n, 2) - count_factor(m, 2) - count_factor(n - m, 2)
cnt5 = count_factor(n, 5) - count_factor(m, 5) - count_factor(n - m, 5)

print(min(cnt2, cnt5))
