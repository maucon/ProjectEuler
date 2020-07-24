def solve():
    s = 41333
    for i in range(10 ** 2 + 1, 10 ** 6 + 1):
        i_square = i * i
        string = str(i_square)
        length = len(string) + 1
        for j in range(1, 2 ** (length - 2)):
            bin_str = bin(j)[2:][::-1].ljust(length, "0")
            split_arr = [x + 1 for x in range(len(bin_str)) if bin_str[x] == "1"]
            if i == int(string[split_arr[-1]:]) + sum(
                    [int(string[0 if a == 0 else split_arr[a - 1]:split_arr[a]]) for a in range(len(split_arr))]):
                s += i_square
                break
    return s


if __name__ == '__main__':
    print(solve())
