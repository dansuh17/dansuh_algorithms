"""
Quickselect 기본 구현
Quicksort와 유사하나 단순히 k번째 요소가 무엇인지만을 알고 싶다.

time - O(n^2), average O(n)
 * n + n/2 + n/4 + n/8 + n/16 .... = 2n
space - O(n)

where
n = number of elements in array
"""


def quickselect(arr, k):
    # should be valid k
    if k > len(arr) or k < 0:
        raise Exception('Invalid k range')

    start = 0
    end = len(arr) - 1
    # convert kth to index value
    return select(arr, k - 1, start, end)


def select(arr, k, start, end):
    if end == start:
        return arr[start + k]

    piv = partition(arr, start, end)
    piv_offset = piv - start
    if piv_offset == k:  # spot on!
        return arr[start + k]
    elif k < piv_offset:
        return select(arr, k, start, piv - 1)
    else:
        return select(arr, k - piv_offset - 1, piv + 1, end)


def partition(arr, start, end):
    # partition, just like we did in quicksort
    piv_idx = start  # can be at any position
    piv_val = arr[piv_idx]

    i = start
    j = end
    while i <= j:
        while i <= j and arr[i] <= piv_val:
            i += 1

        while i <= j and arr[j] > piv_val:
            j -= 1

        if i <= j:
            arr[i], arr[j] = arr[j], arr[i]

    # pivot value should be located at i - 1
    arr[piv_idx], arr[i - 1] = arr[i - 1], arr[piv_idx]
    return i - 1


if __name__ == '__main__':
    print(quickselect([1, 2, 6, 4, 1, 7, 9, 20, 99, 1, -6, 7, 81, 23, 15, 66], 11))
    print(sorted([1, 2, 6, 4, 1, 7, 9, 20, 99, 1, -6, 7, 81, 23, 15, 66]))  # for reference
