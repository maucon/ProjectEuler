def solve(permutations=5):
    perm = dict()
    i = 10
    while True:
        key = ''.join(sorted(list(str(i ** 3))))
        if key in perm:
            perm[key].append(i)
            if len(perm[key]) == permutations:
                return perm[key][0] ** 3
        else:
            perm.update({key: [i]})
        i += 1
