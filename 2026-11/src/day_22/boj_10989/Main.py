import sys

input = sys.stdin.readline

n = int(input())
cnt = [0] * (1 + 10000)
for _ in range(n):
    cnt[int(input())] += 1

for x in range(1, 10001):
    for _ in range(cnt[x]):
        print(x)
