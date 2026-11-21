import sys
from itertools import combinations_with_replacement

input = sys.stdin.readline

n, m = map(int, input().split())
out = [" ".join(map(str, seq)) for seq in combinations_with_replacement(range(1, n + 1), m)]
print("\n".join(out))
