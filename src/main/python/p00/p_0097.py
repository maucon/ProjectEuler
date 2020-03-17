# Find the last ten digits of this prime number -> 28433×2^7830457+1.
def solve():
    b = 1
    for i in range(7830457):
        b *= 2
        if b > 9999999999:
            b = int(str(b)[-10:])
    return str(b * 28433 + 1)[-10:]
