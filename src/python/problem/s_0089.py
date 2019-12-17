def solve():
    rules = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    with open('res/p_0089.txt') as f:
        for line in f.read().split('\n'):
            count = 0
            for c in line:
                count += rules[c]
            print(count)