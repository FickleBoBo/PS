import sys

input = sys.stdin.readline

n = int(input())

pivot = n
out = []
for i in range(1, 2 * n):
    out.append(" " * (pivot - 1) + "*" * (n - pivot + 1))
    if i < n:
        pivot -= 1
    else:
        pivot += 1

print("\n".join(out))
