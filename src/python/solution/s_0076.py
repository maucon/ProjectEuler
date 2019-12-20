def solve(limit=100):
    ways = [1] + [0] * limit

    for i in range(1, 100):  # value 1-99
        for j in range(i, limit + 1):
            ways[j] = ways[j] + ways[j - i]

    return ways[100]
