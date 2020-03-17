def solve(limit=2000000):
    e = 1, 1
    for m in range(1, 101):
        for n in range(1, m):
            s = 0
            for a in range(m, 0, -1):
                for b in range(min(n, m - 1), 0, -1):
                    s += a * b
            if abs(s - 2000000) < limit:
                limit = abs(2000000 - s)
                e = m, n

    return e[0] * e[1]
