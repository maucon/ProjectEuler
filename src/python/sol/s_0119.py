def solve(n=30):
    solved = []
    for i in range(2, 1000):
        b = i
        while b < 1000000000000000:
            if b > 9:
                q = 0
                for c in str(b):
                    q += int(c)
                if q == i:
                    solved.append([b, i])
            b *= i
    return sorted(solved)[n - 1][0]
