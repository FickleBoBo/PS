import sys

input = sys.stdin.readline
out = []

INF = 1_000_000_000

tc = 1
while True:
    n = int(input())
    if n == 0:
        break

    arr = [list(map(int, input().split())) for _ in range(n)]

    dp = [[0] * 3 for _ in range(n)]
    dp[0][0] = INF
    dp[0][1] = arr[0][1]
    dp[0][2] = arr[0][1] + arr[0][2]
    for i in range(1, n):
        dp[i][0] = min(dp[i - 1][0], dp[i - 1][1]) + arr[i][0]
        dp[i][1] = min(dp[i][0], dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]) + arr[i][1]
        dp[i][2] = min(dp[i][1], dp[i - 1][1], dp[i - 1][2]) + arr[i][2]

    out.append(f"{tc}. {dp[n - 1][1]}")
    tc += 1

print("\n".join(out))
