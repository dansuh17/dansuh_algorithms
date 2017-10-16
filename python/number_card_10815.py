"""
백준 문제 10815번 '숫자 카드'
https://www.acmicpc.net/problem/10815

전형적 binary search 문제

time - O(n log n) (from sorting) O(log n) (average for binary search)
space - O(n)
auxillary space - O(1) - can be done in-place
"""


def number_card():
    n = int(input())
    cards = [int(c) for c in input().strip().split()]
    m = int(input())
    to_find = [int(c) for c in input().strip().split()]
    cards = sorted(cards)  # sort the cards beforehand

    result = []
    for s in to_find:
        result.append(find(s, cards, 0, n - 1))

    print(' '.join(result))


def find(k, cards, start, end):
    # perform binary search
    if start > end:
        # failed to find
        return '0'

    # perform binary search
    mid = (start + end) // 2
    if k == cards[mid]:
        return '1'
    elif k < cards[mid]:
        return find(k, cards, start, mid - 1)
    else:
        return find(k, cards, mid + 1, end)


if __name__ == '__main__':
    number_card()
