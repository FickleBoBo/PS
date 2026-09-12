def solution(myStr):
    ans = myStr.translate(str.maketrans("abc", "   ")).split()
    return ans if ans else ["EMPTY"]
