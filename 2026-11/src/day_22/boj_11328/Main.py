import sys

input = sys.stdin.readline

n = int(input())
out = []
for _ in range(n):
    a, b = input().split()
    out.append("Possible" if sorted(a) == sorted(b) else "Impossible")

print("\n".join(out))
