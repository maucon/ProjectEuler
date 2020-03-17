def solve(limit=100000000):
    s = 1  # n = 1 works
    psieve = [True] * (limit + 2)
    for k in range(4, len(psieve), 2):
        psieve[k] = False
    for p in range(3, len(psieve), 2):
        if psieve[p]:
            prime = p - 1
            for i in range(1, int(prime ** 0.5) + 1):
                if prime / i == int(prime / i):
                    i = int(i + prime / i)
                    if not psieve[i]:
                        break
            else:
                s += prime
            for i in range(p * 2, len(psieve), p):
                psieve[i] = False
    return s
