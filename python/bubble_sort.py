"""
Bubble sort 기본 구현
array의 처음에서 맨 끝까지 거품처럼 떠오르는 느낌

time - O(n^2)
space - n
"""


def bubble_sort(arr):
    l = len(arr) - 1
    for i in range(l):
        for j in range(l - i):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

    return arr


if __name__ == '__main__':
    print(bubble_sort([1, 2, 6, 4, 1, 7, 9, 20, 99, 1, -6, 7, 81, 23, 15, 66]))
