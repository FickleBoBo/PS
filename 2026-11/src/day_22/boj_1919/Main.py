import sys
from collections import Counter

input = sys.stdin.readline

a = Counter(input().rstrip())
b = Counter(input().rstrip())
print(sum(((a - b) + (b - a)).values()))
