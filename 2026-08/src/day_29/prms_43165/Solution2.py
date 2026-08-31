import sys

sys.setrecursionlimit(10**6)


def solution(numbers, target):
    n = len(numbers)

    def dfs(cur, depth):
        if depth == n:
            return int(cur == target)
        return dfs(cur + numbers[depth], depth + 1) + dfs(cur - numbers[depth], depth + 1)

    return dfs(0, 0)
