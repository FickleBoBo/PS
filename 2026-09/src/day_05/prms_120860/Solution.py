def solution(dots):
    xs, ys = zip(*dots)
    return (max(xs) - min(xs)) * (max(ys) - min(ys))
