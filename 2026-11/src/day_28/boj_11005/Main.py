import string
import sys

input = sys.stdin.readline

n, b = map(int, input().split())
digits = string.digits + string.ascii_uppercase
res = []
while n:
    n, d = divmod(n, b)
    res.append(digits[d])

print("".join(reversed(res)))
