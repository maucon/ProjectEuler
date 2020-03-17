def solve(limit=50000000):
    prime = [2]
    psieve = [True] * (int((limit - 24) ** 0.5) + 1)
    for i in range(3, len(psieve), 2):
        if psieve[i]:
            prime.append(i)
            for j in range(i * i, len(psieve), i * 2):
                psieve[j] = False

    s = set()
    for a in prime:
        for b in prime:
            for c in prime:
                num = a * a + b * b * b + c * c * c * c
                if num < limit:
                    s.add(num)
                else:
                    break
    return len(s)
