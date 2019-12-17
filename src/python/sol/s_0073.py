def solve(limit=12000):
    c = 0
    for d in range(3, limit + 1):
        for n in range(d // 3, d // 2 + 1):
            div = n / d
            if div >= 0.5:
                break
            x, y = d, n
            while y:
                x, y = y, x % y
            if x == 1 and 0.5 > div > (1 / 3):
                c += 1
    return c
