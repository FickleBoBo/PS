import sys

input = sys.stdin.readline

n = int(input())

out = []
for i in range(1, n + 1):
    out.append(" " * (n - i) + "*" * (2 * i - 1))

print("\n".join(out))
