import math
import sys

input = sys.stdin.readline

input()
arr = list(map(int, input().split()))

first = arr[0]
for r in arr[1:]:
    g = math.gcd(first, r)
    print(f"{first // g}/{r // g}")
