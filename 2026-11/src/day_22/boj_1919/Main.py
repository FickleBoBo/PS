import sys
from collections import Counter

input = sys.stdin.readline

a = Counter(input().strip())
b = Counter(input().strip())

print(sum(((a - b) + (b - a)).values()))
