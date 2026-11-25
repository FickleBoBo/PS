import sys

input = sys.stdin.readline

n = int(input())
out = []
for _ in range(n):
    s = input().strip()
    out.append("yes" if 6 <= len(s) <= 9 else "no")

print("\n".join(out))
