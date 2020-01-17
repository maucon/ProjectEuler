import os


def solve():
    def matrix_solver_recursive(x=0, y=0):
        if (x, y) in m.keys():
            return m[x, y]
        if x + 1 == len(matrix):
            m[x, y] = sum([matrix[x][yy] for yy in range(y, len(matrix))])
            return m[x, y]
        if y + 1 == len(matrix):
            m[x, y] = sum([matrix[xx][y] for xx in range(x, len(matrix))])
            return m[x, y]
        m[x, y] = matrix[x][y] + min(matrix_solver_recursive(x + 1, y), matrix_solver_recursive(x, y + 1))
        return m[x, y]

    with open(os.path.dirname(os.path.abspath(__file__)) + '/res/p_0081.txt') as f:
        matrix = list()
        for line in f.readlines():
            matrix.append([int(x) for x in line[0:-1].split(',')])
        m = dict()
        return matrix_solver_recursive()
