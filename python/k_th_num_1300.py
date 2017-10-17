import math
"""
백준 문제 1300번 'k번째 숫자'
https://www.acmicpc.net/problem/1300

N * N 테이블에서 k번째 숫자 찾기

time - O(n log n)  (2 log n 번 찾는 것이 최대, 각 찾을 때마다 최대 N번 계산 (num_under 함수))
space - O(log n) for function calls, but O(1) if tail-call optimized
auxillary space - O(log n)
"""


def kth_num():
    n = int(input())
    k = int(input())

    # exclude zeros
    return check(1, n * n, k, n)


def check(min, max, k, max_n):
    # min, max 숫자 내에서 k 번째 숫자 찾기. 한 변의 길이는 MAX_N이다.
    if min > max:
        # check availability
        _, avail = num_under(min, max_n)
        if avail:
            return min
        else:
            # go one numbers down until available
            return check(min - 1, min - 1, k, max_n)

    mid = (min + max) // 2
    num_under_mid, available = num_under(mid, max_n)

    if num_under_mid == k and available:
        return mid  # found!
    elif num_under_mid == k and not available:
        # proceed one steps down until available
        return check(mid - 1, mid - 1, k, max_n)
    elif num_under_mid > k:
        # find within lower bounds
        return check(min, mid - 1, k, max_n)
    else:
        # find within upper bounds
        return check(mid + 1, max, k, max_n)


def num_under(m, max_n):
    # count numbers less than or equal to m
    floor_sqrt = int(math.sqrt(m))
    count = 0
    available = False
    for denom in range(1, floor_sqrt + 1):
        divided = m // denom
        # check whether M is within the grid
        if not available:
            if divided <= max_n and m % denom == 0:
                available = True
        count += min(divided, max_n)
    return count * 2 - (floor_sqrt * floor_sqrt), available


if __name__ == '__main__':
    print(kth_num())
