def solution(n, computers):
    p = list(range(n))

    def find(x):
        while x != p[x]:
            p[x] = p[p[x]]
            x = p[x]
        return x

    def union(x, y):
        x, y = find(x), find(y)
        if x == y:
            return False
        p[x] = y
        return True

    for i in range(n):
        for j in range(i + 1, n):
            if computers[i][j]:
                union(i, j)

    return sum(i == p[i] for i in range(n))
