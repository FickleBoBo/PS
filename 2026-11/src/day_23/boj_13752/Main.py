import sys

input = sys.stdin.readline

n = int(input())

out = []
for _ in range(n):
    k = int(input())
    out.append("=" * k)

print("\n".join(out))
