def solve():
    num = [1, 1]
    for k in reversed([2, 1, 2] + [1 if x % 3 else 2 + (2 * x // 3) for x in range(1, 97)]):
        num = [num[1], k * num[1] + num[0]]
    return sum(map(int, str(num[1])))
