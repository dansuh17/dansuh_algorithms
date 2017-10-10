"""
Merge sort 기본 구현
길이 2인 애들이 될때까지 쪼갠 다음에 합칠 때 순서가 맞게 합친다.

time - O(n log n)
space - O(n)


* other approaches usually focus on reducing space complexity.
* in the worst case, merge sort makes 39% less comparisons than quicksort
"""


def merge_sort(arr):
    l = len(arr)
    if l < 2:
        return arr

    halfway = l // 2
    return merge(merge_sort(arr[:halfway]), merge_sort(arr[halfway:]))


def merge(left, right):
    """Merge two arrays, assuming that both arrays are sorted already."""
    l1 = len(left)
    l2 = len(right)

    i = 0
    j = 0

    result = []
    while i < l1 and j < l2:
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    if i == l1:
        result += right[j:]
    elif j == l2:
        result += left[i:]
    return result


if __name__ == '__main__':
    print(merge_sort([1, 2, 6, 4, 1, 7, 9, 20, 99, 1, -6, 7, 81, 23, 15, 66]))
