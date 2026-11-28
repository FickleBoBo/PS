import sys

input = sys.stdin.readline

total = 0
while True:
    x = int(input())
    if x == -1:
        break
    total += x

print(total)
