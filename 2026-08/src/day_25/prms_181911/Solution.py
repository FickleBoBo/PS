def solution(my_strings, parts):
    return "".join(word[s : e + 1] for word, (s, e) in zip(my_strings, parts))
