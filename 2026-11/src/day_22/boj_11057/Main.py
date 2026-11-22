import sys

input = sys.stdin.readline

MOD = 10007

n = int(input())
dp = [[0] * 10 for _ in range(1 + n)]
for j in range(10):
    dp[1][j] = 1

for i in range(2, n + 1):
    for j in range(10):
        dp[i][j] = sum(dp[i - 1][j:]) % MOD

print(sum(dp[n]) % MOD)
