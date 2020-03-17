def solve(number=600851475143):
    i = 2
    while i * i < number:
        while number % i == 0:
            number //= i
        i += 1
    return number
