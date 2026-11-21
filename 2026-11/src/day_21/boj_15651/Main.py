import sys
from itertools import product

input = sys.stdin.readline

n, m = map(int, input().split())
out = [" ".join(map(str, seq)) for seq in product(range(1, n + 1), repeat=m)]
print("\n".join(out))
