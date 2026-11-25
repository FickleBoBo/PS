import sys

input = sys.stdin.readline

n = int(input())
out = []
for _ in range(n):
    r, e, c = map(int, input().split())
    if r > e - c:
        out.append("do not advertise")
    elif r < e - c:
        out.append("advertise")
    else:
        out.append("does not matter")

print("\n".join(out))
