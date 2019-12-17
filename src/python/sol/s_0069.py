# Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
def solve(limit=1000000):
    num = 2
    psieve = [True for _ in range(int(limit ** 0.5) + 1)]
    for p in range(3, len(psieve), 2):
        if psieve[p]:
            if num * p > limit:
                break
            num *= p
            for i in range(p * 2, len(psieve), p):
                psieve[i] = False
    return num
