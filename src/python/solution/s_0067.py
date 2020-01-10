import os


def solve():
    with open(os.path.dirname(os.path.abspath(__file__)) + '/res/p_0067.txt', 'r') as f:
        lines = []
        for line in f.read().split('\n'):
            lines.append([int(x) for x in line.split(' ')])
        for i in reversed(range(1, len(lines))):
            for j in range(i):
                lines[i - 1][j] += max(lines[i][j], lines[i][j + 1])
        return lines[0][0]
