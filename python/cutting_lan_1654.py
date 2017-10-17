"""
백준 문제 1654번 '랜선 자르기'
https://www.acmicpc.net/problem/1654

time - O(n log n), for sorting and finding the cable
space - O(k) for storing cable lengths
auxiliary space - O(1)
"""


def cut_ethernet():
    k, n = [int(c) for c in input().strip().split()]
    cables = []
    for _ in range(k):
        cables.append(int(input()))

    cables = sorted(cables, reverse=True)
    maxlen = cables[0]

    start = 0
    end = maxlen

    while start <= end:
        mid = int(start / 2 + end / 2)
        num_cables, is_larger = test_len(cables, mid, n)
        if is_larger:
            start = mid + 1
        elif num_cables == n:
            # proceed to find max length
            start = mid + 1
        else:  # need to make smaller cables
            end = mid - 1

    # maximum length
    return end


def test_len(cables, l, test_n):
    num_cables = 0
    is_larger = False
    # assume sorted
    for cable in cables:
        can_create = cable // l
        num_cables += can_create

        if num_cables > test_n:
            is_larger = True
            break
    return num_cables, is_larger


if __name__ == '__main__':
    print(cut_ethernet())
