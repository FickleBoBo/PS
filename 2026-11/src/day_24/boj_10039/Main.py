import sys

input = sys.stdin.readline

total = 0
for _ in range(5):
    total += max(int(input()), 40)

print(total // 5)
