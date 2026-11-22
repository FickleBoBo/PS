import sys

input = sys.stdin.readline

n, k = map(int, input().split())
cnt = [[0] * 2 for _ in range(1 + 6)]
for _ in range(n):
    s, y = map(int, input().split())
    cnt[y][s] += 1

ans = 0
for y in range(1, 7):
    for s in range(2):
        ans += (cnt[y][s] + k - 1) // k

print(ans)
