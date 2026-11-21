import sys
from itertools import permutations

input = sys.stdin.readline

n, m = map(int, input().split())
out = [" ".join(map(str, seq)) for seq in permutations(range(1, n + 1), m)]
print("\n".join(out))
