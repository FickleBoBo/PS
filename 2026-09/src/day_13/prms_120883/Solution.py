def solution(id_pw, db):
    for uid, upw in db:
        if id_pw[0] != uid:
            continue

        return "login" if id_pw[1] == upw else "wrong pw"

    return "fail"
