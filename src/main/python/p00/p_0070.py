smallestDiv = []
phiSaved = []
ratio = 0


def solve(limit=10000000):
    global smallestDiv, ratio, phiSaved

    smallestDiv = sieve(limit)
    phiSaved = [1 for _ in range(limit)]
    ratio = limit

    result = 0
    for n in range(3, limit, 2):

        phiSaved[n] = phi(n)
        if n / phiSaved[n] > ratio:
            continue

        if sorted(str(n)) == sorted(str(phiSaved[n])):
            ratio = n / phiSaved[n]
            result = n

    return result


def phi(n):
    global smallestDiv, ratio

    if smallestDiv[n] == n:
        return n - 1

    x = n
    while x % smallestDiv[n] == 0:
        x /= smallestDiv[n]

    return (smallestDiv[n] - 1) * phiSaved[int(x)]


def sieve(limit):
    prime_sieve = [-1 for _ in range(limit)]
    prime_sieve[::2] = [2 for _ in range(len(prime_sieve[::2]))]
    for p in range(3, limit, 2):
        if prime_sieve[p] != -1:
            continue
        for i in range(p, limit, p):
            if prime_sieve[i] == -1:
                prime_sieve[i] = p

    return prime_sieve
