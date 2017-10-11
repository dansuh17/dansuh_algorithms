import operator
"""
백준 문제 7459번 'k번째 숫자'
https://www.acmicpc.net/problem/7459

파이썬으로 이렇게 풀면 시간초과 뜨는거같음 ㅠㅠㅠ
original index를 유지하는 방식을 사용함
펜윅 트리인지 뭔지를 써야 더 빠르게 풀 수 있는듯 

time - O(n log n) (from sorting)
space - O(n)
"""


def kth_number():
    n, m = [int(a) for a in input().strip().split()]
    arr = [int(c) for c in input().strip().split()]

    # sort this
    sorted_array = sorted(enumerate(arr), key=operator.itemgetter(1))

    for _ in range(m):
        i, j, k = [int(b) for b in input().strip().split()]
        count = 0
        for orig_idx, elem in sorted_array:
            if i - 1 <= orig_idx < j:
                count += 1
                if count == k:
                    print(elem)
                    break


if __name__ == '__main__':
    kth_number()
