import sys

input = sys.stdin.readline

n = int(input())
if n % 5 == 0:
    print(n // 5)
elif n >= 3 and (n - 3) % 5 == 0:
    print((n - 3) // 5 + 1)
elif n >= 6 and (n - 6) % 5 == 0:
    print((n - 6) // 5 + 2)
elif n >= 9 and (n - 9) % 5 == 0:
    print((n - 9) // 5 + 3)
elif n >= 12 and (n - 12) % 5 == 0:
    print((n - 12) // 5 + 4)
else:
    print(-1)
