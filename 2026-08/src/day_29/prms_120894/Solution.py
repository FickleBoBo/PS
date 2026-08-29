def solution(numbers):
    words = [
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
    ]

    for d, w in enumerate(words):
        numbers = numbers.replace(w, str(d))

    return int(numbers)
