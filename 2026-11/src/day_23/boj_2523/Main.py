import sys

input = sys.stdin.readline

n = int(input())

pivot = 1
out = []
for i in range(1, 2 * n):
    out.append("*" * pivot)
    if i < n:
        pivot += 1
    else:
        pivot -= 1

print("\n".join(out))
