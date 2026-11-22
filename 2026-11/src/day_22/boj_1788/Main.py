import sys

input = sys.stdin.readline

MOD = 1_000_000_000

n = int(input())
m = abs(n)
dp = [0] * (1 + m + 1)
dp[1] = 1
for i in range(2, m + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) % MOD

if n == 0:
    sign = 0
elif n > 0 or m % 2 != 0:
    sign = 1
else:
    sign = -1

print(sign)
print(dp[m])
