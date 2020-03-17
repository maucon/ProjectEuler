def solve(limitx=100, limity=1000):
    lp = 0
    for x in range(limity, limitx, -1):
        for y in range(limity, limitx, -1):
            m = x * y
            if m > lp:
                if str(m)[::-1] == str(m):
                    lp = m
            else:
                break
    return lp
