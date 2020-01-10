from itertools import compress


def solve(limit=100000000):
    plimit = limit // 2
    sieve = bytearray([True] * (plimit // 2))
    for i in range(3, int(plimit ** 0.5) + 1, 2):
        if sieve[i // 2]:
            sieve[i * i // 2::i] = bytearray((plimit - i * i - 1) // (2 * i) + 1)
    primes = [2, *compress(range(3, plimit, 2), sieve[1:])]

    s = 0
    while len(primes) > 1:
        if primes[-1] * primes[0] >= limit:
            primes.pop()
            continue
        s += len(primes)
        primes.remove(primes[0])
    return s + 1 if len(primes) == 1 and primes[0] * primes[0] < limit else s
