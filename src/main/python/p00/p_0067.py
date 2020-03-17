import requests


def solve():
    lines = []
    for line in requests.get("https://projecteuler.net/project/resources/p067_triangle.txt").text.split('\n')[:-1]:
        lines.append([int(x) for x in line.split(' ')])
    for i in reversed(range(1, len(lines))):
        for j in range(i):
            lines[i - 1][j] += max(lines[i][j], lines[i][j + 1])
    return lines[0][0]
