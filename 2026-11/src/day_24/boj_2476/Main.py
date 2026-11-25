import sys

input = sys.stdin.readline

mx = 0

n = int(input())
for _ in range(n):
    a, b, c = map(int, input().split())

    if a == b == c:
        mx = max(mx, 10000 + a * 1000)
    elif a == b:
        mx = max(mx, 1000 + a * 100)
    elif b == c:
        mx = max(mx, 1000 + b * 100)
    elif c == a:
        mx = max(mx, 1000 + c * 100)
    else:
        mx = max(mx, max(a, b, c) * 100)

print(mx)
