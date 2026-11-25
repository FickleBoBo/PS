import sys

input = sys.stdin.readline

w, h = map(int, input().split())
print(f"{0.5 * w * h:.1f}")
