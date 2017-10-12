from itertools import permutations
"""
카카오 문제 68번 'n queen problem'
https://www.welcomekakao.com/learn/challenge_codes/68

n x n 체스판에서 여왕을 n개 놓을 수 있는 경우의 수 찾기

Raymond Hettinger's Algorithm:
- demonstrates the power of itertools.permutations()


time - O(m)
space - O(n + m)
"""


def nQueen(n):
    num_combination = 0
    cols = range(n)
    for perm in permutations(cols):
        # row not being overlapped is guaranteed by permutation function
        # check if diagonal moves do not overlap
        if n == len(set(perm[i] + i for i in cols)) == len(set(perm[i] - i for i in cols)):
            num_combination += 1

    return num_combination


if __name__ == '__main__':
    print(nQueen(8))