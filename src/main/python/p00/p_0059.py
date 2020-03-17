import requests


def solve():
    k = [101, 120, 112]  # password is 'exp'
    s = 0
    for i, e in enumerate(list(map(int, requests.get("https://projecteuler.net/project/resources/p059_cipher.txt").text.split(',')))):
        s += e ^ k[i % 3]
    return s
