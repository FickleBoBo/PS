import sys

input = sys.stdin.readline

mx, r, c = -1, 0, 0
for i in range(1, 10):
    for j, x in enumerate(map(int, input().split()), 1):
        if x > mx:
            mx, r, c = x, i, j

print(mx)
print(r, c)
