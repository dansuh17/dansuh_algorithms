import random

"""
Implementation of recursive quick sort.
"""


def quicksort(arr):
    if len(arr) <= 1:
        return arr

    first, pivot, last = partition(arr)
    result = quicksort(first) + [pivot] + quicksort(last)
    return result


def partition(arr):
    # randomly select pivot
    arr_size = len(arr)
    pivot_index = random.randrange(arr_size)
    pivot = arr[pivot_index]

    # move pivot to head of the array
    tmp = arr[0]
    arr[0] = arr[pivot_index]
    arr[pivot_index] = tmp

    i = 0
    j = arr_size - 1
    while i <= j:
        # 이렇게 하면 마지막 단계에서 무조건 i - 1번째 element가 pivot보다 같거나 작다
        # i가 먼저 움직이기 때문
        while i <= j and arr[i] <= pivot:
            i += 1

        while i <= j and arr[j] > pivot:
            j -= 1

        if i <= j:
            # swap
            tmp = arr[i]
            arr[i] = arr[j]
            arr[j] = tmp

    # pivot을 가운데로 갖다놓는다
    tmp = arr[0]
    arr[0] = arr[i - 1]
    arr[i - 1] = tmp
    return arr[:i - 1], arr[i - 1], arr[i:]


if __name__ == '__main__':
    array = [1, 2, 6, 4, 267, 8, 6, 4, 2, 5, 11, 99, 6, 3]
    print(quicksort(array))
