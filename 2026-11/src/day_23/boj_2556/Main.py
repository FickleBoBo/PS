import sys

input = sys.stdin.readline

n = int(input())

out = []
for _ in range(n):
    out.append("*" * n)

print("\n".join(out))
