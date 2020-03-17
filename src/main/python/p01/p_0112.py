def solve(limit=0.99):
    i, b = 100, 0
    while True:
        bs = str(i)
        s, ls = sorted(bs), list(bs)
        if not (s == ls or s == ls[::-1]):
            b += 1
            if b / i >= limit:
                return i
        i += 1
