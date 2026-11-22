import sys

input = sys.stdin.readline

n = int(input())

arr = [[0] * (1 + n) for _ in range(1 + n)]
for i in range(1, n + 1):
    arr[i][1 : i + 1] = map(int, input().split())

dp = [[0] * (1 + n) for _ in range(1 + n)]
for i in range(1, n + 1):
    for j in range(1, i + 1):
        dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j]

print(max(dp[n]))
