import sys

input = sys.stdin.readline

MOD = 10007

n = int(input())
dp = [0] * (1 + n + 1)
dp[1] = 1
dp[2] = 3
for i in range(3, n + 1):
    dp[i] = (2 * dp[i - 2] + dp[i - 1]) % MOD

print(dp[n])
