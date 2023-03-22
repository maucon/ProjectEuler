import math


def solve(n=800800):
    count = 0

    highest = int(n * math.log(n) / math.log(2))
    primes = prime_sieve(highest)

    index = len(primes) - 1
    for p in range(len(primes)):
        for pair in primes[index:p:-1]:
            if n - primes[p] * math.log(pair, n) < pair * math.log(primes[p], n):
                index -= 1
                continue
            count += index - p
            break

    return count


def prime_sieve(limit):
    primes = [2]
    sieve = [True for _ in range(limit + 1)]
    for i in range(3, limit + 1, 2):
        if not sieve[i]:
            continue
        primes.append(i)
        sieve[i * i:limit + 1: i] = [False] * len(sieve[i * i:limit + 1: i])
    return primes

