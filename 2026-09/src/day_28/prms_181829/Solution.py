def solution(board, k):
    total = 0
    for i, row in enumerate(board[: k + 1]):
        for j, x in enumerate(row):
            if i + j > k:
                break
            total += x

    return total
