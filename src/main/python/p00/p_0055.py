def solve(limit=10000):
    c = 0
    for i in range(5, limit):
        for _ in range(50):
            i += int(str(i)[::-1])
            if str(i)[::-1] == str(i):
                break
        else:
            c += 1
    return c
