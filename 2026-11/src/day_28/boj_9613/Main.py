import math
import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, *arr = map(int, input().split())

    total = 0
    for i in range(n - 1):
        for j in range(i + 1, n):
            total += math.gcd(arr[i], arr[j])

    print(total)
