import sys

input = sys.stdin.readline

n = int(input())

if n % 2:
    print(f"{n} is odd")
else:
    print(f"{n} is even")
