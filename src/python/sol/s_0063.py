# How many n-digit positive integers exist which are also an nth power?
def solve():
    c = 1
    for b in range(2, 10):
        e = 1
        while e <= len(str(b ** e)):
            if e == len(str(b ** e)):
                c += 1
            e += 1
    return c
