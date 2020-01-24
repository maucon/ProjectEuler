def solve(limit=1000000000):
    s = 0
    for i in [x for x in range(1, limit + 1) if x % 10 != 0]:
        for c in str(i + int(str(i)[::-1])):
            if int(c) & 1 == 0:
                break
        else:
            s += 1
    return s
