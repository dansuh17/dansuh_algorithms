import operator
"""
Selection sort 기본 구현
array의 앞부터 작은 순서대로 채우는 방식

time - O(n^2)
space - O(n)  (original array)
"""


def selection_sort(arr):
    for i in range(len(arr) - 1):
        j, min_remaining = min(enumerate(arr[i + 1:]), key=operator.itemgetter(1))
        min_idx = j + i + 1
        # 남은 array에서 최소값을 찾았으면 현재 위치와 바꿔준다
        arr[min_idx], arr[i] = arr[i], arr[min_idx]

    return arr


if __name__ == '__main__':
    print(selection_sort([1, 2, 6, 4, 1, 7, 9, 20, 99, 1, -6, 7, 81, 23, 15, 66]))
