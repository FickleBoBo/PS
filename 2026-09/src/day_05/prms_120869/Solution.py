def solution(spell, dic):
    spell.sort()

    for s in dic:
        if spell == sorted(s):
            return 1

    return 2
