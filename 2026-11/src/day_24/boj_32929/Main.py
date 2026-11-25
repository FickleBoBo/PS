import sys

input = sys.stdin.readline

x = int(input())
print("UOS"[(x - 1) % 3])
