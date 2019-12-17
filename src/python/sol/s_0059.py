# Find the sum of the ASCII values in the original text.
def solve():
    with open('res/p_0059.txt') as f:
        k = [101, 120, 112]  # password is 'exp'
        s = 0
        for i, e in enumerate(list(map(int, f.read().split(',')))):
            s += e ^ k[i % 3]
        return s
