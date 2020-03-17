import os


def solve():
    with open(os.path.dirname(os.path.abspath(__file__)) + '/res/p_0059.txt') as f:
        k = [101, 120, 112]  # password is 'exp'
        s = 0
        for i, e in enumerate(list(map(int, f.read().split(',')))):
            s += e ^ k[i % 3]
        return s
