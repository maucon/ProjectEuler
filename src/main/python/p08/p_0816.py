mod = 50515093


def solve(n=2000000):
    points_x = []

    x = 290797
    for i in range(n):
        points_x.append(x)
        x = pow(x, 4, mod)

    points_x.sort()

    shortest_dist = (2 * mod ** 2) ** .5
    for pS in range(n):
        for pE in range(pS + 1, n):
            if points_x[pE] - points_x[pS] >= shortest_dist:
                break

            dist = distance(points_x[pS], pow(points_x[pS], 2, mod), points_x[pE], pow(points_x[pE], 2, mod))
            if dist < shortest_dist:
                shortest_dist = dist

    return format(shortest_dist, ".9f")


def distance(x1, y1, x2, y2):
    return ((x1 - x2) ** 2 + (y1 - y2) ** 2) ** .5
