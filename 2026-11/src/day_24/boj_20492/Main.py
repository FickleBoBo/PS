import sys

input = sys.stdin.readline

n = int(input())
print(n // 100 * 78, n // 100 * 80 + n // 100 * 78 * 20 // 100)
