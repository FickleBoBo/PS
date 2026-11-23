import sys

input = sys.stdin.readline

n = int(input())

l, r = n, n
out = []
for i in range(1, 2 * n):
    out.append(" " * (l - 1) + "*" * (r - l + 1))
    if i < n:
        l -= 1
        r += 1
    else:
        l += 1
        r -= 1

print("\n".join(out))
