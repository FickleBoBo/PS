def solution(keyinput, board):
    pos = [0, 0]
    maxx, maxy = board[0] // 2, board[1] // 2

    for key in keyinput:
        if key == "up":
            pos[1] = min(pos[1] + 1, maxy)
        elif key == "down":
            pos[1] = max(pos[1] - 1, -maxy)
        elif key == "left":
            pos[0] = max(pos[0] - 1, -maxx)
        else:
            pos[0] = min(pos[0] + 1, maxx)

    return pos
