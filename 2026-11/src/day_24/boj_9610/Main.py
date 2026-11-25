import sys

input = sys.stdin.readline

cnt = [0] * 5

n = int(input())
for _ in range(n):
    x, y = map(int, input().split())

    if x == 0 or y == 0:
        cnt[0] += 1
        continue

    if x > 0:
        if y > 0:
            cnt[1] += 1
        else:
            cnt[4] += 1
    else:
        if y > 0:
            cnt[2] += 1
        else:
            cnt[3] += 1

print(f"Q1: {cnt[1]}")
print(f"Q2: {cnt[2]}")
print(f"Q3: {cnt[3]}")
print(f"Q4: {cnt[4]}")
print(f"AXIS: {cnt[0]}")
