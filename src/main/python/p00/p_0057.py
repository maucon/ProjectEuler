def solve(limit=1000):
    f1, f2 = [1, 1], [3, 2]
    c = 0
    for i in range(limit - 1):
        f1, f2 = f2, [f2[0] * 2 + f1[0], f2[1] * 2 + f1[1]]
        if len(str(f2[0])) > len(str(f2[1])):
            c += 1
    return c
